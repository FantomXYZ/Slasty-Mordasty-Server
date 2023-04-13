package by.fpmibsu.slastymordasty.dao;


import java.sql.*;

public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/slastymordasty";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Driver mySqlDriver;
    private Connection connection;


    public MySQLConnection(){
        try {
            this.mySqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(this.mySqlDriver);
            this.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
