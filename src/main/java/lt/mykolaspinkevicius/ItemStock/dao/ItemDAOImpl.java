package lt.mykolaspinkevicius.ItemStock.dao;

import lt.mykolaspinkevicius.ItemStock.entity.Item;
import lt.mykolaspinkevicius.ItemStock.exceptions.NoItemFoundException;
import lt.mykolaspinkevicius.ItemStock.jpa.ItemRepository;
import lt.mykolaspinkevicius.ItemStock.mappers.MapItemToItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemDAOImpl implements Dao<Item> {

    @Autowired
    ItemRepository repository;

    @Override
    public Item getItemById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoItemFoundException("No Item Found"));
    }

    @Override
    public List<Item> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Item> getItemsWithValidDate(LocalDate date) {
        return repository.findAll().stream()
                .filter(x -> x.getValidUntil()
                        .compareTo(date) >= 0).collect(Collectors.toList());
    }

    @Override
    public void save(Item item) {
        repository.save(item);
    }

    @Override
    public void update(Item item) {
        repository.findById(item.getId()).ifPresent(x -> {
            MapItemToItem.mapItemToItem(x, item);
            repository.save(x);
        });
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow(
                () -> new NoItemFoundException("No item found while deleting")));
    }

}
