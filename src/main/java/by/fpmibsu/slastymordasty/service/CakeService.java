package by.fpmibsu.slastymordasty.service;

import by.fpmibsu.slastymordasty.dao.CakeDao;
import by.fpmibsu.slastymordasty.entity.Cake;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class CakeService {

    private static final Logger log = Logger.getLogger(CakeService.class);
    private CakeDao cakeDao;

    public CakeService() throws SQLException, InterruptedException {
        cakeDao = new CakeDao();
        log.info("Call constructor");
    }


    public List<Cake> getAll() throws InterruptedException {

        return cakeDao.getAll();
    }

    public Cake getById(long id) throws InterruptedException {
        return cakeDao.getById(id);
    }
}
