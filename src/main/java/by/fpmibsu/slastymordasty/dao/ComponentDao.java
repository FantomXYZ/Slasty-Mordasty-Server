package by.fpmibsu.slastymordasty.dao;

import by.fpmibsu.slastymordasty.entity.Component;
import by.fpmibsu.slastymordasty.entity.Image;
import by.fpmibsu.slastymordasty.entity.NutritionalValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComponentDao {

    public static final String GET_ALL = "SELECT * FROM component";
    public static final String GET_BY_ID = "SELECT * FROM component WHERE idComponent = ?";

    public static final String GET_PRICE = "SELECT * FROM component WHERE idComponent = ?";
    Connection connection;

    public ComponentDao(){
        MySQLConnection mySQLConnection = new MySQLConnection();
        connection = mySQLConnection.getConnection();
    }


    public double getPriceById(long id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRICE);
            preparedStatement.setLong(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.getDouble("price");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Component> getAllComponent(){

        List<Component> list = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Component component = new Component();

                component.setId(rs.getLong("idComponent"));
                component.setTitle(rs.getString("title"));
                component.setPrice(rs.getDouble("price"));
                component.setDescription(rs.getString("description"));

                long nvId = rs.getLong("idNutritionalValue");

                NutritionalValueDao nutritionalValueDao = new NutritionalValueDao();
                NutritionalValue nv = nutritionalValueDao.getById(nvId);;

                component.setNutritionalValue(nv);

                long imId = rs.getLong("idImage");

                ImageDao imageDao = new ImageDao();
                Image image = imageDao.getImageById(imId);

                component.setImage(image);
                list.add(component);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Component getComponentById(long id){
        Component component = new Component();

        try {
            PreparedStatement ps = connection.prepareStatement(GET_BY_ID);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            component.setId(rs.getLong("idComponent"));
            component.setTitle(rs.getString("title"));
            component.setPrice(rs.getDouble("price"));
            component.setDescription(rs.getString("description"));

            long nvId = rs.getLong("idNutritionalValue");

            NutritionalValueDao nutritionalValueDao = new NutritionalValueDao();
            NutritionalValue nv = nutritionalValueDao.getById(nvId);;

            component.setNutritionalValue(nv);

            long imId = rs.getLong("idImage");

            ImageDao imageDao = new ImageDao();
            Image image = imageDao.getImageById(imId);

            component.setImage(image);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return component;
    }


}
