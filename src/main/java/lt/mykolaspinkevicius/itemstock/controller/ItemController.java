package lt.mykolaspinkevicius.itemstock.controller;

import lt.mykolaspinkevicius.itemstock.dto.ItemDTO;
import lt.mykolaspinkevicius.itemstock.entity.Item;
import lt.mykolaspinkevicius.itemstock.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    public static final String ITEM_DATE_FORMAT = "yyyy-MM-dd";
    @Autowired
    private ItemService itemService;

    @GetMapping("/getAllItems")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> body = itemService.getAllItems();
        return ResponseEntity.ok(body);
    }

    @GetMapping("/getItemById")
    public ResponseEntity<Item> getItemById(@RequestParam Long id) {
        Item body = itemService.getItemById(id);
        return ResponseEntity.ok(body);
    }

    @GetMapping("/getItemsWithValidDate")
    public ResponseEntity<List<Item>> getItemsWithValidDate(@RequestParam @DateTimeFormat(pattern=ITEM_DATE_FORMAT) LocalDate date) {
        List<Item> body = itemService.getItemsWithValidDate(date);
        return ResponseEntity.ok(body);
    }

    @GetMapping("/getItemsWithProvidedAvailableQuantityAndType")
    public ResponseEntity<List<ItemDTO>> getItemsWithProvidedAvailableQuantityAndType(@RequestParam String type, @RequestParam Long quantity) {
        List<ItemDTO> body = itemService.getItemsWithProvidedAvailableQuantityAndType(type, quantity);
        return ResponseEntity.ok(body);
    }

    @PostMapping("/addItem")
    public ResponseEntity<Void> addItem(@RequestBody Item item) {
        itemService.save(item);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateItem")
    public ResponseEntity<Void> updateItem(@RequestBody Item item) {
        itemService.update(item);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/deleteItem")
    public ResponseEntity<Void> deleteItem(@RequestParam Long id) {
        itemService.delete(id);
        return ResponseEntity.ok().build();
    }


}
