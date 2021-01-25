package lt.mykolaspinkevicius.ItemStock.service;

import lt.mykolaspinkevicius.ItemStock.dao.Dao;
import lt.mykolaspinkevicius.ItemStock.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    Dao<Item> itemDao;

    public List<Item> getAllItems() {
        return itemDao.getAll();
    }

    public Item getItemById(Long id) {
        return itemDao.getItemById(id);
    }

    public List<Item> getItemsWithValidDate(LocalDate date) {
        return itemDao.getItemsWithValidDate(date);
    }

    public void save(Item item) {
        itemDao.save(item);
    }

    public void update(Item item) {
        itemDao.update(item);
    }

    public void delete(Long id) {
        itemDao.delete(id);
    }

}
