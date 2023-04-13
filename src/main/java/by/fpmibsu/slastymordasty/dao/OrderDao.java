/*
package by.fpmibsu.slastymordasty.dao;

import by.fpmibsu.slastymordasty.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    public static final String GET_ALL = "SELECT * FROM orders";
    Connection connection;

    OrderDao(){
        MySQLConnection myConnection = new MySQLConnection();
        connection = myConnection.getConnection();
    }

    public List<Order> getAllOrders(){
        List<Order> list = new ArrayList<Order>();
        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("user_id"));
                order.setItem(rs.getInt("item"));
                order.setQuantity(rs.getInt("quantity"));
                order.setPrice(rs.getDouble("price"));
                list.add(order);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;

    }
}
*/
