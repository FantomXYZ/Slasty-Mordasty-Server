package by.fpmibsu.slastymordasty.dao;

import by.fpmibsu.slastymordasty.entity.Component;
import by.fpmibsu.slastymordasty.entity.Constructor;
import by.fpmibsu.slastymordasty.entity.Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ConstructorDao {

    final double priceForKg = 50;
    Connection connection;

    public static final String GET_BY_ID = "SELECT * FROM constructor WHERE idFinalProduct = ?";
    public static final String INSERT_NEW = "INSERT INTO constructor (idImage,radius,height,price) VALUES (?,)";

    public ConstructorDao(){
        MySQLConnection mySQLConnection = new MySQLConnection();
        connection = mySQLConnection.getConnection();
    }

    public Constructor getById(long id){

        Constructor constructor = new Constructor();

        try {
            PreparedStatement ps = connection.prepareStatement(GET_BY_ID);
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();

            constructor.setId(rs.getLong("idFinalProduct"));

            long imId = rs.getLong("idImage");

            ImageDao imageDao = new ImageDao();
            Image image = imageDao.getImageById(imId);

            constructor.setImage(image);

            ComponentsDao componentsDao = new ComponentsDao();

            List<Component> recipe = componentsDao.getAllByFinalProductId(id);
            constructor.setRecipe(recipe);

            double price = 0;

            ComponentDao componentDao = new ComponentDao();

            for(Component item: recipe){
                price += componentDao.getPriceById(item.getId());
            }

            constructor.setPrice(price);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return constructor;

    }




}
