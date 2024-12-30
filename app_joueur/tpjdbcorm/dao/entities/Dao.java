package ma.enset.tpjdbcorm.dao.entities;

import java.util.List;

public interface Dao<T> {
    public void save(T t);
    public void update(T t);
    void deleteById(int id);
    T findById(int id);
    public List<T> findAll();
}
