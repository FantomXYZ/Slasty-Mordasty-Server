package by.fpmibsu.slastymordasty.dao;

import by.fpmibsu.slastymordasty.dao.pool.ConnectionPool;
import by.fpmibsu.slastymordasty.entity.Order;
import by.fpmibsu.slastymordasty.entity.Cake;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.fpmibsu.slastymordasty.entity.Item.quantity;


public class OrderProdDao {
    Connection connection;

    public static final String GET_ALL_BY_ID = "SELECT * FROM orderProd WHERE orderId =?";

    public OrderProdDao(){}

    public List<Order> getAllOrders() throws SQLException, InterruptedException{
        connection = ConnectionPool.getConnection();
        List<Order> list = new ArrayList<>();


        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_BY_ID);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Order order = new Order();
                Cake cake = new Cake();
                order.setId(rs.getInt("ORDERID"));
                cake.setId(rs.getLong("idDessert"));
                //?  cake.quantity(rs.getString("EMAIL"));
                list.add(order);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ConnectionPool.closeConnection(connection);

        return list;
    }
}
