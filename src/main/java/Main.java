import by.fpmibsu.slastymordasty.dao.UserDao;
import by.fpmibsu.slastymordasty.entity.User;

import java.sql.*;

public class Main {



    public static void main(String[] args) throws SQLException {



        UserDao userDao = new UserDao();
        //userDao.insertUser(new User("Fantom", "p_d@mail.ru", "+375445591987","fan",1,"Октябрьская","703/10"));

        for(User user: userDao.getAllUsers()){
            System.out.println(user.toString());
        }



    }


}
