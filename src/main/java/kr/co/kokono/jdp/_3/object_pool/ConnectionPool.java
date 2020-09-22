package kr.co.kokono.jdp._3.object_pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {
    private String url;
    private String uid;
    private String upw;
    private String driver;

    private int min;
    private int max;

    //사용 가능한 대기 커넥션 객체가 담길 저장소
    private Vector<Connection> free = new Vector<>(1, 1);

    //사용 중인 커넥션 객체의 저장소
    private Vector<Connection> occupied = new Vector<>(1, 1);

    //사용 가능한 커넥션 객체가 반환될때까지 대기하기 위한 신호값
    private boolean monitorFlag;

    public ConnectionPool(String url, String uid, String upw, String driver, int min, int max) {
        this.url = url;
        this.uid = uid;
        this.upw = upw;
        this.driver = driver;
        this.min = min;
        this.max = max;

        //사용할 드라이버 로딩
        loadDriver();
        //최초 min개의 커넥션 객체를 생성
        init();
    }

    //커넥션 객체 생성 메서드
    private Connection makeConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, uid, upw);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //초기값으로 min개수의 커넥션 객체를 생성
    private void init() {
        for (int i = 0; i <= min; i++) {
            free.addElement(makeConnection());
        }
    }

    //드라이버 로딩 메서드
    private void loadDriver() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //사용 가능한 커넥션 객체를 꺼내오는 메서드
    public synchronized Connection getConnection() {
        Connection connection = null;

        //커넥션풀안에 사용 가능한 대기 커넥션 객체가 없다면
        if (!isAvailable()) {
            //최대 max개수만큼 커넥션 객체를 생성한다.
            connection = makeMoreConnection();
        } else {
            //커넥션 풀안에 사용가능한 대기 커넥션 객체가 존재한다면
            connection = getFreeConnection();
        }

        //
        if (connection == null) {
            monitorFlag = true;
            try {
                //사용가능한 커넥션 객체가 돌아올 때까지 대기
                wait();

                //사용 가능한 커넥션 객체가 돌아오면 이를 취득한다.
                connection = getFreeConnection();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return connection;


    }

    /**
     * 대기 중인 커넥션을 반환받는 메서드
     */
    private Connection getFreeConnection() {
        //free저장소에서 하나 빼오고
        Connection connection = free.firstElement();

        //사용중 상태로 바꿔주고
        transferFreeToOccupied(connection);

        return connection;
    }

    /**
     * 사용 가능한 커넥션 객체가 더는 존재하지 않을 때
     * 추가로 커넥션 객체를 최대한 생성하는 메서드
     */
    private Connection makeMoreConnection() {
        boolean flag = false;

        for (int size = occupied.size(); size < max; size++) {

            /*
            생성할 수 있는 최대 커넥션 객체의 수를 제한한다.
            이런 제한된 범위 하에서 최대한 생성하도록 한다.
            생성 후 대기 커넥션 공간에 추가한다.
             */
            free.addElement(makeConnection());

            //추가로 생성된 객체는 사용 가능상태로 바꾼다.
            flag = true;
        }

        Connection connection = null;

        //만약 새로 생성된 커넥션 객체가 있다면 바로 첫번째 커넥션을 꺼내서 리턴한다.
        if (flag) {
            connection = free.firstElement();
            flag = false;
        }
        return connection;
    }

    /**
     * 재활용하기 위해 커넥션 객체를 수거하는 메서드
     */
    public synchronized void releaseConnection(Connection connection) {

        //사용중인 커넥션 객체를 사용 가능한 대기 커넥션 상태로 바꿔주고
        transferOccupiedToFree(connection);

        //사용중인 커넥션 객체를 occupied로부터 제거
        remove(connection);

        /*
        사용할 커넥션 객체를 할당받지 못해 대기중인 클라이언트에게
        사용 가능한 커넥션 객체가 생성되었음을 통보한다.
         */
        if (monitorFlag) {
            notify();
            monitorFlag = false;
        }
    }


    /*
    사용중이던 커넥션 객체를 사용중인 커넥션 저장소 occupied로부터 제거한다.
    그렇지 않으면 occupied의 크기는 무한대로 커질 것이다.
     */
    private void remove(Connection connection) {
        Connection removeConnection;
        for (int i = 0; i < occupied.size(); i++) {
            //occupied에서 제거할 커넥션을 찾아낸다
            removeConnection = occupied.get(i);

            if (connection.equals(removeConnection)) {
                //해당 커넥션과 데이터베이스와의 연결을 종료한다.
                close(connection);
                occupied.remove(connection);
            }
        }
    }

    private void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 사용 중이던 커넥션 객체를 대기 상태로 전이시키는 메서드
     */
    private void transferOccupiedToFree(Connection connection) {
        //free에 추가한다.
        free.addElement(connection);
    }

    /**
     * 대기 중이던 커넥션 객체를 사용중인 상태로 전이시키는 메서드
     */
    private void transferFreeToOccupied(Connection connection) {

        //free로부터 첫번째 커넥션을 제거하고
        free.remove(0);

        //occupied에 추가한다.
        occupied.addElement(connection);
    }

    /**
     * 사용 가능한 커넥션 객체가 존재하는지 확인
     */
    public boolean isAvailable() {
        return free.isEmpty() ? false : true;
    }
}
