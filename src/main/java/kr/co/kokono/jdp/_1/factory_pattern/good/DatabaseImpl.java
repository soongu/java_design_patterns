package kr.co.kokono.jdp._1.factory_pattern.good;

import java.sql.*;

public class DatabaseImpl implements Database {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public DatabaseImpl() {
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

    public DatabaseImpl(String id) {

    }

    public Connection getConnection() {
        return conn;
    }
}
