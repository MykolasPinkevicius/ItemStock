package lt.mykolaspinkevicius.ItemStock.dao;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Dao<T> {
    T getById(Long id);

    List<T> getAll();

    List<T> getWithValidDate(LocalDate date);

    void save(T t);

    void update(T t);

    void delete(Long id);

    List<T> getWithProvidedAvailableQuantityAndType(String type, Long quantity);
}
