package lt.mykolaspinkevicius.ItemStock.controller;

import lt.mykolaspinkevicius.ItemStock.ItemStockApplication;
import lt.mykolaspinkevicius.ItemStock.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = ItemStockApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerTests {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port + "/items";
    }

    @Test
    void contextLoads() {}

    @Test
    void shouldReturnAnyItemsWhenGettingThemAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/getAllItems",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    void shouldReturnItemWhenGettingById() {
//        Need to insert something before we can test
//        because currently database is in memory and after each application start it deletes temporary memory.
        restTemplate.postForEntity(getRootUrl() + "/addItem", createItem(), Item.class);
        Item item = restTemplate.getForObject(getRootUrl() + "/getItemById/1", Item.class);
        assertNotNull(item);
    }

    @Test
    void shouldCreateItem() {
        ResponseEntity<Item> postResponse = restTemplate.postForEntity(getRootUrl() + "/addItem", createItem(), Item.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    private Item createItem() {
        Item item = new Item();
        item.setValidUntil(LocalDate.now().plusDays(14L));
        item.setType("Fake Gold");
        item.setQuantity(14L);
        item.setCreated(LocalDate.now());
        return item;
    }
}
