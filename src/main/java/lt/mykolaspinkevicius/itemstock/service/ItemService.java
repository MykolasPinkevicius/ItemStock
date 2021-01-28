package lt.mykolaspinkevicius.itemstock.service;

import lt.mykolaspinkevicius.itemstock.entity.Item;
import lt.mykolaspinkevicius.itemstock.exceptions.NoItemFoundException;
import lt.mykolaspinkevicius.itemstock.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ItemService {

    private static final String NOT_FOUND_BY_USING_GET_BY_ID = "Item isn't founded while trying to get it by id";

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new NoItemFoundException(NOT_FOUND_BY_USING_GET_BY_ID));
    }

    public List<Item> getItemsWithValidDate(LocalDate date) {
        return itemRepository.findWithValidDate(date);
    }

    public void save(Item item) {
        itemRepository.save(item);
    }

    public void update(Item item) {
        itemRepository.save(item);
    }

    public void delete(Long id) {
        itemRepository.delete(itemRepository.findById(id).orElseThrow(() -> new NoItemFoundException(NOT_FOUND_BY_USING_GET_BY_ID)));
    }

    public List<Item> getItemsWithProvidedAvailableQuantityAndType(String type, Long quantity) {
        return itemRepository.findWithProvidedAvailableQuantityAndType(type, quantity);
    }

}
