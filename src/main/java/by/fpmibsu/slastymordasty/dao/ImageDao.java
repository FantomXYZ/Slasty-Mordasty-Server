package by.fpmibsu.slastymordasty.dao;

import by.fpmibsu.slastymordasty.entity.Image;
import by.fpmibsu.slastymordasty.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDao {
    Connection connection;

    public static final String GET_ALL  = "SELECT * FROM image";
    public static final String GET_BY_ID = "SELECT * FROM image WHERE idImage =?";

    public static final String INSERT_NEW = "INSERT INTO image (path) VALUES (?)";

    public static final String UPDATE_PATH = "UPDATE image SET PATH =? WHERE idImage =?";

    public ImageDao(){
        MySQLConnection myconn = new MySQLConnection();
        connection = myconn.getConnection();
    }


    public List<Image> getAllImages(){
        List<Image> list = new ArrayList<>();


        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Image image = new Image();
                image.setId(rs.getInt("idImage"));
                image.setPath(rs.getString("path"));
                list.add(image);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public Image getImageById(long id){
        Image image = new Image();

        try {
            PreparedStatement ps = connection.prepareStatement(GET_BY_ID);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                image.setId(rs.getInt("idImage"));
                image.setPath(rs.getString("path"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return image;
    }


    public void insertImage(Image image){
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_NEW);
            ps.setString(1, image.getPath());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateImage(Image image){
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_PATH);
            ps.setString(1, image.getPath());
            ps.setLong(2, image.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
