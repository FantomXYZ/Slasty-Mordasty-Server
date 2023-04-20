package by.fpmibsu.slastymordasty.dao;

import java.sql.Connection;

public class NutritionalValueDao {

    Connection connection;

    public NutritionalValueDao() {
        MySQLConnection myconn = new MySQLConnection();
        connection = myconn.getConnection();
    }


}
