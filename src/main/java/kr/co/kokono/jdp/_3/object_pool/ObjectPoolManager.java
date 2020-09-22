package kr.co.kokono.jdp._3.object_pool;

import java.sql.Connection;

/**
 * 객체 풀 매니저는 하나면 충분하므로
 * 싱글톤 패턴을 적용합니다.
 */
public class ObjectPoolManager {

    //싱글톤 적용1
    private static ObjectPoolManager instance = new ObjectPoolManager();

    //DB 커넥션 정보
    private static final String URL = "jdbc:mysql://localhost:3306/jdp?serverTimezone=Asia/Seoul";
    private static final String UID = "root";
    private static final String UPW = "mysql";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    //최소, 최대 커넥션 객체 수
    private static final int MIN = 5;
    private static final int MAX = 10;

    //커넥션 풀
    private ConnectionPool pool;

    //싱글톤 적용2
    private ObjectPoolManager() {
        this.pool = new ConnectionPool(URL, UID, UPW, DRIVER, MIN, MAX);
    }

    //싱글톤 적용3
    public static ObjectPoolManager getInstance() {
        return instance;
    }

    /**
     * 사용할 Connection 객체를 커넥션풀에서 꺼내는 메서드
     * Connection객체의 공유를 막도록 동기화 메서드로 선언
     */
    public synchronized Connection getConnection() {
        return pool.getConnection();
    }

    /**
     * 사용을 마친 Connection 객체를 커넥션풀로 돌려놓는 메서드
     * Connection객체의 공유를 막도록 동기화 메서드로 선언
     */
    public synchronized void releaseConnection(Connection connection) {
        pool.releaseConnection(connection);
    }
}
