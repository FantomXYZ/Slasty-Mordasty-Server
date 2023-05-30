package test.fpmibsu.slastymordasty.dao;

import by.fpmibsu.slastymordasty.entity.User;
import by.fpmibsu.slastymordasty.service.UserService;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class UserServiceTest {
    UserService userService = new UserService();

    public UserServiceTest() throws SQLException {
    }

    @Test()
    void getByEmailPassword() throws SQLException {
        long id = 1;
        User user = new User(1,"Анатолий","anatolyM@gmail.com","+375296772344","tolik",0,"Корженевского","23 12");
        assertEquals(userService.getUserByEmailPassword("anatolyM@gmail.com","tolik"),user);
    }
}
