package kr.co.kokono.jdp._1.factory_pattern.good;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @benefit
 *
 * 이전과 달리 DatabaseFactory를 통해 객체를 제공받았을 경우 이점은 뭘까요?
 * 만약 Database객체를 사용하는 클래스 BusinessA ~ BusinessZ가 존재한다 했을 때
 * 모두 객체 생성을 아래의 설계처럼 위임받은 클래스(Factory)에게 반환받는다면
 * Database객체의 생성자가 변경된다 하더라도  -> Database(String id);
 *
 * 이제는 이전과 달리 모든 A~Z의 클래스를 수정하는 것이 아닌
 * DatabaseFactoryImpl 클래스의 코드 한줄을 수정하면 됩니다.
 *  return new Database();   ---->   return new Database("xxx");
 */
public class BusinessA {

    DatabaseFactory df = new DatabaseFactoryImpl();
    Database db = df.getDatabase();

    Connection conn = db.getConnection();

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
