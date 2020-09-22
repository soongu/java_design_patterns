package kr.co.kokono.jdp._1.factory_pattern.bad;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Waring
 * 이런 코딩방식의 문제점:
 * 만약 Database객체를 활용하는 Business클래스가 100개이고
 * new Database() 코드가 new Database(id); 로 변경된다면
 * 100개의 클래스의 코드를 변경해야 함
 *
 * @Solution
 * 객체 생성을 위임한다.
 * Business 클래스에서 직접 객체를 생성하지 말고 Database객체 생성을 전담하는 클래스를 두고
 * Database객체를 요구하는 모든 클래스는 직접 생성하는 것이 아니라 이 클래스를 통해
 * 참조하도록 하는 것!
 */
public class Business {

    Database db = new Database();
    Connection conn = db.getConn();

    public void insert(String id, String code, int quality) {
        String sql = "insert into product values (?, ?, ?)";

        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, code);
            pstmt.setInt(3, quality);

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
