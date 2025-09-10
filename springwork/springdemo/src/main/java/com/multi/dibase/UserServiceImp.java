package com.multi.dibase;
//UserServiceImp는 UserDaoJdbcImp를 의존하는 설계도입니다
public class UserServiceImp {
    //선언부에서 UserServiceImp이 의존하는 객체인 UserDaoJdbcImp객체를 di한다
    //의존성이란? 의존하는 객체의 reference를 취득하는 것
    private UserDaoJdbcImp jdbcImp=new UserDaoJdbcImp();;

    public void actionSelect(){
        jdbcImp.actionSearch();;//의존성 객체를 통해서 구현합니다...


    }
    public UserServiceImp(UserDaoJdbcImp jdbcImp) {
        this.jdbcImp = jdbcImp;
        jdbcImp.actionSearch();
    }

    public UserDaoJdbcImp getJdbcImp() {
        jdbcImp.actionSearch();
        return jdbcImp;
    }

    public void setJdbcImp(UserDaoJdbcImp jdbcImp) {
        this.jdbcImp = jdbcImp;
    }

    public static void main(String[] args) {
        //의존성 주입을 생성자를 통해서...
        UserServiceImp userServiceImp=new UserServiceImp(new UserDaoJdbcImp());
       //의종성 주입을 setter메소드를 통해서 주입합니다..
        userServiceImp.setJdbcImp(new UserDaoJdbcImp());

    }
}
