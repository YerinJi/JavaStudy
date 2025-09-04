package com.multi.todo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String URL  = "jdbc:mysql://localhost:3306/tododb?serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASS = "1234";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 8
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
