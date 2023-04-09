package by.fpmibsu.slastymordasty.dao;

import by.fpmibsu.slastymordasty.entity.Role;
import by.fpmibsu.slastymordasty.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao{

    private static final String SELECT = "SELECT";
    private static final String FROM = "FROM user ";
    private static final String ALL = " * ";
    private static final String INSERT = "INSERT INTO user ";

    private static final String VALUES_NEW = "(NAME,EMAIL,PHONE,PASSWORD,ROLE,ADDRESS) VALUES";

    private Statement statement;

    public UserDao(){
        MySQLStatement con = new MySQLStatement();
        statement = con.getStatement();
    }

    public List<User> getAllUsers(){

        List<User> list = new ArrayList<>();


        try {
            ResultSet resultSet = statement.executeQuery(SELECT + ALL + FROM);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");
                String phone = resultSet.getString("PHONE");
                String password = resultSet.getString("PASSWORD");
                int role = resultSet.getInt("ROLE");
                String address = resultSet.getString("ADDRESS");

                list.add(new User(id,name,email,phone,password,role,address));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;

    }

    public void insertUser(User user){


        String name = user.getName();
        String email = user.getEmail();
        String phone = user.getPhoneNumber();
        String password = user.getPassword();
        int role = user.getRole();
        String address = user.getAddress();

        String s = "('" + name + "','" + email + "','" + phone + "','" + password + "','" + role + "','" + address + "')";


        try {
            statement.executeUpdate(INSERT + VALUES_NEW + s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

