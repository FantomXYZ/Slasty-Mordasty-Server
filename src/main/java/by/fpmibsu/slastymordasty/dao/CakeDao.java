package by.fpmibsu.slastymordasty.dao;

import by.fpmibsu.slastymordasty.entity.Cake;
import by.fpmibsu.slastymordasty.entity.Item;
import by.fpmibsu.slastymordasty.entity.NutritionalValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CakeDao {
    Connection connection;

    public static final String GET_ALL = "SELECT * FROM dessert";
    public static final String GET_BY_ID = "SELECT * FROM dessert WHERE idDessert = ?";

    //public static final String INSERT_NEW = "INSERT INTO image (idNutritionalValue,idImage,title,description,price) VALUES (?,?,?,?,?)";

    public CakeDao(){
        MySQLConnection mySQLConnection = new MySQLConnection();
        connection = mySQLConnection.getConnection();
    }

    public List<Cake> getAll() {
        List<Cake> list = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()){
                Cake cake = new Cake();
                cake.setId(resultSet.getLong("idDessert"));

                NutritionalValueDao nutritionalValueDao = new NutritionalValueDao();
                long nutId = resultSet.getLong("idNutritionalValue");
                cake.setNutritionalValue100g(nutritionalValueDao.getById(nutId));

                ImageDao imageDao = new ImageDao();
                long imId = resultSet.getLong("idImage");
                cake.setImage(imageDao.getImageById(imId));

                cake.setTitle(resultSet.getString("title"));

                cake.setDescription(resultSet.getString("description"));

                cake.setPrice(resultSet.getDouble("price"));

                list.add(cake);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public Cake getById(long id){
        Cake cake = new Cake();


        try {
            PreparedStatement ps = connection.prepareStatement(GET_BY_ID);
            ps.setLong(1,id);

            ResultSet resultSet = ps.executeQuery();

            if(resultSet.next()){
                cake.setId(resultSet.getLong("idCake"));

                NutritionalValueDao nutritionalValueDao = new NutritionalValueDao();
                long nutId = resultSet.getLong("idNutritionalValue");
                cake.setNutritionalValue100g(nutritionalValueDao.getById(nutId));

                ImageDao imageDao = new ImageDao();
                long imId = resultSet.getLong("idImage");
                cake.setImage(imageDao.getImageById(imId));

                cake.setTitle(resultSet.getString("title"));

                cake.setDescription(resultSet.getString("description"));

                cake.setPrice(resultSet.getDouble("price"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return cake;
    }
}
