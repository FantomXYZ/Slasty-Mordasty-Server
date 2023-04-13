package by.fpmibsu.slastymordasty.dao;

import by.fpmibsu.slastymordasty.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao{
    Connection connection;

    public static final String GET_ALL = "SELECT * FROM user";
    public static final String INSERT_NEW = "INSERT INTO user(NAME,EMAIL,PHONE,PASSWORD,ROLE,ADDRESS) VALUES(?,?,?,?,?,?)";

    public static final String DELETE_ID ="DELETE FROM user WHERE ID =?";

    public static final String UPDATE_EMAIL = "UPDATE user SET EMAIL =? WHERE ID =?";
    public static final String UPDATE_PHONE = "UPDATE user SET PHONE =? WHERE ID =?";
    public static final String UPDATE_PASSWORD = "UPDATE user SET PASSWORD =? WHERE ID =?";
    public static final String UPDATE_ADDRESS = "UPDATE user SET ADDRESS =? WHERE ID =?";

    public UserDao(){
        MySQLConnection mySQLConnection = new MySQLConnection();
        connection = mySQLConnection.getConnection();
    }

    public List<User> getAllUsers(){
        List<User> list = new ArrayList<User>();


        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("NAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setPhoneNumber(rs.getString("PHONE"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setRole(rs.getInt("ROLE"));
                user.setAddress(rs.getString("ADDRESS"));
                list.add(user);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public void insertUser(User user){
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_NEW);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhoneNumber());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getRole());
            ps.setString(6, user.getAddress());

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteUserById(long id){
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_ID);
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUserEmail(long id, String email){
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_EMAIL);
            ps.setString(1, email);
            ps.setLong(2, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUserPhone(long id,String phone){
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_PHONE);
            ps.setString(1, phone);
            ps.setLong(2, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUserPassword(long id,String password){
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_PASSWORD);
            ps.setString(1, password);
            ps.setLong(2, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUserAddress(long id,String address){
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_ADDRESS);
            ps.setString(1, address);
            ps.setLong(2, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

