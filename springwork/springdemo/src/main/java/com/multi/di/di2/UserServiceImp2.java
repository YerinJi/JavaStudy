package com.multi.di.di2;

public class UserServiceImp2 implements UserService {
    private  UserDao userDao=new UserDaoJdbcImp();
    @Override
    public void register() {
        userDao.insert();

    }

    @Override
    public void findUser() {

    }
}
