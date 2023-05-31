package by.fpmibsu.slastymordasty.service;

import by.fpmibsu.slastymordasty.dao.CakeDao;
import by.fpmibsu.slastymordasty.entity.Cake;

import java.sql.SQLException;
import java.util.List;

public class CakeService {

    private CakeDao cakeDao;

    public CakeService() throws SQLException, InterruptedException {
        cakeDao = new CakeDao();
    }


    public List<Cake> getAll() throws InterruptedException {
        return cakeDao.getAll();
    }

    public Cake getById(long id) throws InterruptedException {
        return cakeDao.getById(id);
    }
}
