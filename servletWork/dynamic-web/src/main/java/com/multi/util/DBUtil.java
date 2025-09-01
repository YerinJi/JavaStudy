
package com.multi.util;

import java.sql.*;
//1. JDBC연결하는 드라이브 코드 설정
//2. MVC구조를 이해하는 코드로 진행
//3. JAVA부분, JSP부분을 구분해서 프로그램 구현
//4. eljstl을 이용하는 목록을 출력

public class DBUtil {
    private static final String URL= "jdbc:mysql://localhost:3306/spring";
    private static final String USER= "root";
    private static final String PASSWORD= "1234";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

