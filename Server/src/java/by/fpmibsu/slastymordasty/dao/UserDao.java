package java.by.fpmibsu.slastymordasty.dao;
import java.by.fpmibsu.slastymordasty.entity.User;
import java.util.List;

public class UserDao extends AbstractDao<User>{

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findEntityById(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        return false;
    }

    @Override
    public User update(User entity) {
        return null;
    }
}
