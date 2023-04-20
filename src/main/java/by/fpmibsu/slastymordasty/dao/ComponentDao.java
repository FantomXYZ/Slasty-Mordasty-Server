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
    Connection connection;

    public ComponentDao(){
        MySQLConnection mySQLConnection = new MySQLConnection();
        connection = mySQLConnection.getConnection();
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
                component.setWeight(rs.getDouble("weight"));
                component.setDescription(rs.getString("description"));

                long nvId = rs.getLong("idNutritionalValue");

                NutritionalValueDao nutritionalValueDao = new NutritionalValueDao();
                NutritionalValue nv = nutritionalValueDao.getById(nvId);;

                component.setNutritionalValue(nv);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


}
