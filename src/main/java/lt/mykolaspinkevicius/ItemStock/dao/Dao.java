package lt.mykolaspinkevicius.ItemStock.dao;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Dao<T> {
    T getItemById(Long id);

    List<T> getAll();

    List<T> getItemsWithValidDate(LocalDate date);

    void save(T t);

    void update(T t);

    void delete(Long id);

    List<T> getItemsWithProvidedAvailableQuantityAndType(String type, Long quantity);
}
