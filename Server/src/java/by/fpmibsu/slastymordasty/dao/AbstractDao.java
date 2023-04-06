package java.by.fpmibsu.slastymordasty.dao;

import java.by.fpmibsu.slastymordasty.entity.Entity;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
public abstract class AbstractDao <T extends Entity> {
    protected Connection connection; // or WrapperConnection or ProxyConnection
    // constructors
    public abstract List<T> findAll();
    public abstract T findEntityById(long id);
    public abstract boolean delete(long id);
    public abstract boolean delete(T entity);
    public abstract boolean create(T entity);
    public abstract T update(T entity);
    public void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            // log
        }
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}