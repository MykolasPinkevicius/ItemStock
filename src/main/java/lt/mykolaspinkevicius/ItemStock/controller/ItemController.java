package lt.mykolaspinkevicius.ItemStock.controller;

import lt.mykolaspinkevicius.ItemStock.entity.Item;
import lt.mykolaspinkevicius.ItemStock.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/getAllItems")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/getItemById")
    public Item getItemById(Long id) {
        return itemService.getItemById(id);
    }
}
