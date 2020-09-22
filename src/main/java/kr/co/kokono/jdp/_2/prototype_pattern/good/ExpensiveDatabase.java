package kr.co.kokono.jdp._2.prototype_pattern.good;

import java.sql.*;
import java.util.Vector;

/**
 * @explanation 이 클래스는 회원 정보를 참조하는 기능을 포함한
 * DB액세스 클래스입니다.
 */
class ExpensiveDatabase {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public static final int DEFAULT = 0, AGE = 1, NAME = 2, TEL = 3;

    /**
     * connect to mysql server
     */
    public ExpensiveDatabase(String server) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdp?serverTimezone=Asia/Seoul";
            conn = DriverManager.getConnection(url, "root", "mysql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Address[] getAllAddresses(int mode) {

        String sql = null;

        //정렬 방식에 따라 쿼리를 바꿈.
        if (mode == DEFAULT) {
            sql = "select * from address";
        } else if (mode == AGE) {
            sql = "select * from address order by ssn";
        } else if (mode == NAME) {
            sql = "select * from address order by name";
        } else if (mode == TEL) {
            sql = "select * from address order by tel";
        }

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Vector<Address> v = new Vector<Address>();

        try {

            while (rs.next()) {
                Address address = new Address(rs);
                v.add(address);
            }

        } catch (SQLException e) {
            System.out.println("can't reference that");
            e.printStackTrace();
        }

        Address[] addresses = new Address[v.size()];
        v.copyInto(addresses);

        return addresses;
    }


}









