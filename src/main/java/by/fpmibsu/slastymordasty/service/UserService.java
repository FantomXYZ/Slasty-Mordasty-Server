package by.fpmibsu.slastymordasty.service;

import by.fpmibsu.slastymordasty.dao.UserDao;
import by.fpmibsu.slastymordasty.entity.User;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDao userDao;

    private static final Logger log = Logger.getLogger(UserService.class);

    public UserService(){
        log.info("Call constructor");
        try {
            userDao = new UserDao();
        } catch (SQLException | InterruptedException e) {
            log.info(e.getMessage());
        }
    }

    public User getUserByEmailPassword(String login,String password){
        log.info("method getUserByEmailPassword");
        try {
            return  userDao.getUserByEmailPassword(login,password);
        } catch (SQLException | InterruptedException e) {
            log.info(e.getMessage());
        }
        return null;
    }

    public boolean isExistByEmailPas(String login,String password){
        try {
            return userDao.isExistByEmailPas(login,password);
        } catch (SQLException | InterruptedException e) {
            log.info(e.getMessage());
        }
        return false;
    }


    public void  insertNew(User user){
        try {
            userDao.insertUser(user);
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
    }

    public List<User> getAllUsers(){
        try {
            return userDao.getAllUsers();
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
        return null;
    }

    public void deleteUserById(long id){
        try {
            userDao.deleteUserById(id);
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
    }

    public void updateUserEmail(long id, String email){
        try {
            userDao.updateUserEmail(id,email);
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
    }

    public void updateUserPhone(long id,String phone){
        try {
            userDao.updateUserPhone(id,phone);
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
    }

    public void updateUserPassword(long id,String password){
        try {
            userDao.updateUserPassword(id,password);
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
    }

    public void updateUserAddress(long id,String addressStreet, String numHouseFlat){
        try {
            userDao.updateUserAddress(id,addressStreet,numHouseFlat);
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
    }
}
