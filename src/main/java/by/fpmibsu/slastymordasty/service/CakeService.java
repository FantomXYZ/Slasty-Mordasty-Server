package by.fpmibsu.slastymordasty.service;

import by.fpmibsu.slastymordasty.dao.CakeDao;
import by.fpmibsu.slastymordasty.entity.Cake;

import java.util.List;

public class CakeService {

    private CakeDao cakeDao;

    public CakeService(){
        cakeDao = new CakeDao();
    }


    public List<Cake> getAll(){
        return cakeDao.getAll();
    }

    public Cake getById(long id){
        return cakeDao.getById(id);
    }
}
