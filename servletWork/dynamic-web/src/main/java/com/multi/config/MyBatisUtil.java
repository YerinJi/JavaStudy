package com.multi.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //단지 reader객체를 생성한다. mybatis-config.xml을 읽어오는 객체를 생성
            //mybatis-config.xml에는 db정보와 sql 쿼리가 존재한다.
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //sqlSessionFactory에는 db정보와 sql정보가 들어있는 상태로 sqlSession을 생성한다.
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            throw new RuntimeException("Error initializing SqlSessionFactory: " + e.getMessage(), e);
        }
    }
    //SqlSession을 만드는 공간이다.
    public static SqlSessionFactory getSqlSessionFactory() { return sqlSessionFactory; }
}
