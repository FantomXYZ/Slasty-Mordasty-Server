package by.fpmibsu.slastymordasty.dao;

import by.fpmibsu.slastymordasty.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao{
    Connection connection;

    public static final String GET_ALL = "SELECT * FROM user";
    public static final String INSERT_NEW = "INSERT INTO user(NAME,EMAIL,PHONENUMBER,PASSWORD,ROLE,ADDRESSSTREET,NUMHOUSEFLAT) VALUES(?,?,?,?,?,?,?)";

    public static final String DELETE_ID ="DELETE FROM user WHERE USERID =?";

    public static final String UPDATE_EMAIL = "UPDATE user SET EMAIL =? WHERE USERID =?";
    public static final String UPDATE_PHONE = "UPDATE user SET PHONENUMBER =? WHERE USERID =?";
    public static final String UPDATE_PASSWORD = "UPDATE user SET PASSWORD =? WHERE USERID =?";
    public static final String UPDATE_ADDRESSSTREET = "UPDATE user SET ADDRESSSTREET =? WHERE USERID =?";
    public static final String UPDATE_NUMHOUSEFLAT = "UPDATE user SET NUMHOUSEFLAT =? WHERE USERID =?";

    public UserDao(){
        MySQLConnection mySQLConnection = new MySQLConnection();
        connection = mySQLConnection.getConnection();
    }

    public List<User> getAllUsers(){
        List<User> list = new ArrayList<>();


        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("USERID"));
                user.setName(rs.getString("NAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setPhoneNumber(rs.getString("PHONENUMBER"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setRole(rs.getInt("ROLE"));
                user.setAddressStreet(rs.getString("ADDRESSSTREET"));
                user.setNumHouseFlat(rs.getString("NUMHOUSEFLAT"));
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
            ps.setString(6, user.getAddressStreet());
            ps.setString(7, user.getNumHouseFlat());

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

    public void updateUserAddress(long id,String addressStreet, String numHouseFlat){
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_ADDRESSSTREET);
            ps.setString(1, addressStreet);
            ps.setLong(2, id);
            ps.execute();

            ps = connection.prepareStatement(UPDATE_NUMHOUSEFLAT);
            ps.setString(1, numHouseFlat);
            ps.setLong(2, id);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}

