package com.multi.service;

import com.multi.dao.UserDao;
import com.multi.dao.UserDaoImpl;
import com.multi.model.User;
import com.multi.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    //UpCast, DownCast,Composition(강한 포함관계), Aggregation(집합관계), 다형성
    private UserDao userDao= new UserDaoImpl();
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUser(int id) { //상세정보
        return userDao.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
