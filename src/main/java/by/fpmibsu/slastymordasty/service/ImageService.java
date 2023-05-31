package by.fpmibsu.slastymordasty.service;


import by.fpmibsu.slastymordasty.dao.ImageDao;
import by.fpmibsu.slastymordasty.entity.Image;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class ImageService {
    private static final Logger log = Logger.getLogger(ImageService.class);

    private ImageDao imageDao;

    public ImageService() throws SQLException, InterruptedException {
        imageDao = new ImageDao();
        log.info("Call constructor");
    }
    public List<Image> getAllImages() throws InterruptedException {
        log.info("method getAllImages");
        return imageDao.getAllImages();
    }

    public Image getImageById(long id) throws InterruptedException {
        log.info("method getImageById");
        return imageDao.getImageById(id);
    }
    public void insertImage(Image image) throws InterruptedException {
        log.info("method insertImage");
        imageDao.insertImage(image);
    }
    public void updateImage(Image image){
        log.info("method updateImage");
        try {
            imageDao.updateImage(image);
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
    }
}
