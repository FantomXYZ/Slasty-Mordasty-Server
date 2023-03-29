package java.by.fpmibsu.slastymordasty.dao;


import java.sql.*;

public class Main {
    public static void main() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/?user=root", "root", "root");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");
            String password = resultSet.getString("LOGIN");
            System.out.println(id + " " + name + " " + password);
        }
    }
}