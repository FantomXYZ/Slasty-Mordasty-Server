package by.fpmibsu.slastymordasty.service;

import by.fpmibsu.slastymordasty.dao.UserDao;
import by.fpmibsu.slastymordasty.entity.User;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDao userDao;

    private static final Logger log = Logger.getLogger(UserService.class);

    public UserService() throws SQLException, InterruptedException {

        userDao = new UserDao();
    }

    public User getUserByEmailPassword(String login,String password) throws SQLException, InterruptedException {
        return  userDao.getUserByEmailPassword(login,password);
    }

    public boolean isExistByEmailPas(String login,String password) throws SQLException, InterruptedException {
        return userDao.isExistByEmailPas(login,password);
    }


    public void  insertNew(User user) throws InterruptedException {
        userDao.insertUser(user);
    }

    public List<User> getAllUsers() throws InterruptedException {
        return userDao.getAllUsers();
    }

    public void deleteUserById(long id) throws InterruptedException{
        userDao.deleteUserById(id);
    }

    public void updateUserEmail(long id, String email) throws InterruptedException{
        userDao.updateUserEmail(id,email);
    }

    public void updateUserPhone(long id,String phone) throws InterruptedException{
        userDao.updateUserPhone(id,phone);
    }

    public void updateUserPassword(long id,String password) throws InterruptedException{
        userDao.updateUserPassword(id,password);
    }

    public void updateUserAddress(long id,String addressStreet, String numHouseFlat) throws InterruptedException{
        userDao.updateUserAddress(id,addressStreet,numHouseFlat);
    }
}
