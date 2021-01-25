package lt.mykolaspinkevicius.ItemStock.controller;

import lt.mykolaspinkevicius.ItemStock.entity.Item;
import lt.mykolaspinkevicius.ItemStock.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/getAllItems")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/getItemById")
    public Item getItemById(@RequestParam Long id) {
        return itemService.getItemById(id);
    }

    @GetMapping("/getItemsWithValidDate")
    public List<Item> getItemsWithValidDate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date) {
        return itemService.getItemsWithValidDate(date);
    }

    @PostMapping("/addItem")
    public void addItem(@RequestBody Item item) {
        itemService.save(item);
    }

    @PutMapping("/updateItem")
    public void updateItem(@RequestBody Item item) {
        itemService.update(item);
    }

    @DeleteMapping("/deleteItem")
    public void deleteItem(@RequestParam Long id) {
        itemService.delete(id);
    }

}
