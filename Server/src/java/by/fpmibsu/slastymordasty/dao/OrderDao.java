package java.by.fpmibsu.slastymordasty.dao;

import java.by.fpmibsu.slastymordasty.entity.Order;
import java.util.List;

public class OrderDao extends AbstractDao<Order> {
    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order findEntityById(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(Order entity) {
        return false;
    }

    @Override
    public boolean create(Order entity) {
        return false;
    }

    @Override
    public Order update(Order entity) {
        return null;
    }
}

