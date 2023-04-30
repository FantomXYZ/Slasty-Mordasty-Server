package by.fpmibsu.slastymordasty.dao;

import by.fpmibsu.slastymordasty.entity.Component;
import by.fpmibsu.slastymordasty.entity.Constructor;
import by.fpmibsu.slastymordasty.entity.Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComponentsDao {
    public static final String GET_ALL_BY_FINAL_PRODUCT_ID = "SELECT * FROM components WHERE idFinalProduct = ?";

    public static final String INSERT_COMPONENT_BY_ID = "INSERT INTO components (idFinalProduct,idComponent) VALUES (?,?)";

    Connection connection;

    public List<Component> getAllByFinalProductId(long id){
        List<Component> list = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_BY_FINAL_PRODUCT_ID);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Long i;
                i = rs.getLong("idComponent");
                ComponentDao componentDao = new ComponentDao();
                list.add(componentDao.getComponentById(i));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void insertNew(Constructor constructor,Component component){
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_COMPONENT_BY_ID);
            ps.setLong(1, constructor.getId());
            ps.setLong(2, component.getId());
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
