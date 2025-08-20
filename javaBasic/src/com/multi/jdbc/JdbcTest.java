package com.multi.jdbc;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/spring";
        String user = "root";
        String password = "1234";

        try{
//            Driver를 가져오는 부분
            Class.forName("com.mysql.jdbc.Driver");
//            연결객체 (Java+Database)
            Connection conn = DriverManager.getConnection(url,user,password);
            // 운반객체
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from emp");
            while(rs.next()){
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
            }
//            메모리에서 지워진다.
            rs.close();
            stmt.close();
            conn.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
