import by.fpmibsu.slastymordasty.dao.MySQLStatement;
import by.fpmibsu.slastymordasty.dao.UserDao;
import by.fpmibsu.slastymordasty.entity.User;

import java.sql.*;
import java.util.List;

public class Main {



    public static void main(String[] args) throws SQLException {



        UserDao userDao = new UserDao();
        //userDao.insertUser(new User("����","van@bsu.by","+375392347406","van",0,"���"));
        for(User user: userDao.getAllUsers()){
            System.out.println(user.toString());
        }



    }


}