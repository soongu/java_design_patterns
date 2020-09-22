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
 *
 * @conclusion
 *
 * Database객체를 필요로하는 Business클래스와 Database클래스는 DatabaseFactory 인터페이스에 의해
 * 서로 의존성이 제거되었으므로(직접 객체 생성이 없어져서) 소스 코드의 수정이
 * 다른 클래스에 영향을 미치지 않게 되는 약한 결합도(loose coupling) 상태가 구현되었습니다.
 *
 * ###  Factory Pattern이란???
 *
 * 객체 생성을 직접 하는 것이 아니라, 타 클래스에게 객체 생성을 위임하는 것을 말합니다.
 * 이 때 객체 생성을 위임받은 클래스(DatabaseFactoryImpl)는 필요한 객체 생성을 선언한
 * 인터페이스(DatabaseFactory)의 구현 클래스가 되어야 하며 그렇게 함으로써
 * 객체 생성에서 변경되어야 하는 코드의 수정을 인터페이스(Database)에서
 * 선언된 API의 구현부 (DatabaseFactory .getDatabase()) 에 국한 시킬 수 있는
 * 유지보수의 편리성과 확장성을 확보할 수 있습니다.
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
