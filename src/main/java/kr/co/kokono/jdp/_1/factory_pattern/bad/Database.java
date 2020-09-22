package kr.co.kokono.jdp._1.factory_pattern.bad;

import java.sql.*;

public class Database {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public Database() {
        String url = "jdbc:mysql://localhost:3306/jdp?serverTimezone=Asia/Seoul";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, "root", "mysql");
//            pstmt = conn.prepareStatement("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {}
        }
    }

    public Connection getConn() {
        return conn;
    }
}
