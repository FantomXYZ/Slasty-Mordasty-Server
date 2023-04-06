package java.by.fpmibsu.slastymordasty.dao;
import java.by.fpmibsu.slastymordasty.entity.Dessert;
import java.util.List;

public class DessertDao extends AbstractDao<Dessert> {

    @Override
    public List<Dessert> findAll() {
        return null;
    }

    @Override
    public Dessert findEntityById(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(Dessert entity) {
        return false;
    }

    @Override
    public boolean create(Dessert entity) {
        return false;
    }

    @Override
    public Dessert update(Dessert entity) {
        return null;
    }
}
