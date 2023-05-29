package by.fpmibsu.slastymordasty.service;

import by.fpmibsu.slastymordasty.dao.UserDao;
import by.fpmibsu.slastymordasty.entity.User;

import java.sql.SQLException;

public class UserService {

    private UserDao userDao;

    public UserService(){
        userDao = new UserDao();
    }

    public User getUserByEmailPassword(String login,String password) throws SQLException {
        return  userDao.getUserByEmailPassword(login,password);
    }

    public boolean isExistByEmailPas(String login,String password) throws SQLException {
        return userDao.isExistByEmailPas(login,password);
    }
}
