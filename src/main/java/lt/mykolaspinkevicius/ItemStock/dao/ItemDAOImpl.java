package lt.mykolaspinkevicius.ItemStock.dao;

import lt.mykolaspinkevicius.ItemStock.entity.Item;
import lt.mykolaspinkevicius.ItemStock.exceptions.NoItemFoundException;
import lt.mykolaspinkevicius.ItemStock.jpa.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    public List<Item> getAllItemsInvalidOrAlmostInvalid() {
        return repository.findAll().stream()
                .filter(x -> x.getValidUntil()
                        .minus(14, ChronoUnit.DAYS)
                        .compareTo(LocalDate.now()) <= -1).collect(Collectors.toList());
    }

    @Override
    public void save(Item item) {
        repository.save(item);
    }

    @Override
    public void update(Item item) {
        repository.findById(item.getId()).ifPresent(x -> {
            mapItem(x, item);
            repository.save(x);
        });
    }

    @Override
    public void delete(Item item) {
        repository.delete(item);
    }

    private void mapItem(Item source, Item updatedSource) {
        source.setCreated(updatedSource.getCreated());
        source.setId(updatedSource.getId());
        source.setQuantity(updatedSource.getQuantity());
        source.setType(updatedSource.getType());
        source.setValidUntil(updatedSource.getValidUntil());
    }
}
