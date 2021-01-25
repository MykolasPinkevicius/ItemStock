package lt.mykolaspinkevicius.ItemStock.dao;

import java.util.List;

public interface Dao<T> {
    T getItemById(Long id);

    List<T> getAll();

    List<T> getAllItemsInvalidOrAlmostInvalid();

    void save(T t);

    void update(T t);

    void delete(T t);
}
