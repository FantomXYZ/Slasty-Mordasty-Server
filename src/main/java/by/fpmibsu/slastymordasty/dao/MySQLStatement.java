package by.fpmibsu.slastymordasty.dao;


import java.sql.*;

public class MySQLStatement {
    private static final String URL = "jdbc:mysql://localhost:3306/slastymordasty";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Driver mySqlDriver;
    private Connection connection;

    private Statement statement;

    public MySQLStatement(){
        try {
            this.mySqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(this.mySqlDriver);
            this.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Statement getStatement() {
        return statement;
    }
}
