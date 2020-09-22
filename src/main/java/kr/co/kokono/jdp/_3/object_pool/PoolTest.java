package kr.co.kokono.jdp._3.object_pool;

import java.sql.Connection;

/**
 * 본 예제에서는 최대 커넥션수가 10개로 되어 있는데,
 * 11명째의 클라이언트 요청이 왔을 때 적절한 동기화를 통해
 * 커넥션을 추가제공하는지 테스트합니다.
 */
public class PoolTest extends Thread {

    public PoolTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        ObjectPoolManager o = ObjectPoolManager.getInstance();
        while (true) {
            //커넥션 풀 매니저를 통해 커넥션을 풀에서 꺼내온다.
            Connection connection = o.getConnection();
            System.out.println("thread name: " + getName() + ", connection: " + connection);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //사용이 끝나면 재활용
            o.releaseConnection(connection);
        }
    }

    public static void main(String[] args) {
        //클라이언트 테스터 11개
        PoolTest[] t = new PoolTest[11];

        //테스트 스레드 11개 생성
        for (int i = 0; i < t.length; i++) {
            t[i] = new PoolTest("client " + (i + 1));
        }


        //테스트 스레드 가동
        for (int i = 0; i < t.length; i++) {
            t[i].start();
        }


    }
}
