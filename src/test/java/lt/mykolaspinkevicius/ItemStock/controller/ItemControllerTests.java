package lt.mykolaspinkevicius.ItemStock.controller;

import lt.mykolaspinkevicius.ItemStock.ItemStockApplication;
import lt.mykolaspinkevicius.ItemStock.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = ItemStockApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerTests {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port + "/items";
    }

    @Test
    void shouldReturnAnyItemsWhenGettingThemAll() {
        List response = restTemplate.getForObject(getRootUrl() + "/getAllItems", List.class);
        assertNotNull(response);
    }

    @Test
    void shouldReturnItemWhenGettingById() {
        postItem();
        Optional<Item> item = restTemplate.getForObject(getRootUrl() + "/getItemById?id=1", Optional.class);
        assertNotNull(item.get());
    }

    @Test
    void shouldCreateItem() {
        ResponseEntity<Item> postResponse = postItem();
        Item getByIdResponse = restTemplate.getForObject(getRootUrl() + "/getItemById?id=1", Item.class);
        assertNotNull(getByIdResponse);
    }

    @Test
    void shouldGetItemsWhenGettingWithValidItemDate() {
        postItem();
        List getResponse = restTemplate.getForObject(getRootUrl() + "/getItemsWithValidDate?"
                + "date=" + LocalDate.now().format(DateTimeFormatter.ISO_DATE), List.class);
        assertNotNull(getResponse);
    }

    @Test
    void shouldUpdateItem() {
        postItem();
        restTemplate.put(getRootUrl() + "/updateItem", updateCreatedItem(), Item.class);
        Item item = restTemplate.getForObject(getRootUrl() + "/getItemById?id=1", Item.class);
        assertEquals("Fake Fake Fake Gold", item.getType());
    }

    @Test
    void shouldGetItemsWhenGettingWithTypeAndQuantity() {
        postItem();
        List getResponse = restTemplate.getForObject(getRootUrl() + "/getItemsWithProvidedAvailableQuantityAndType?"
                + "type=Fake Gold" + "&" + "quantity=15", List.class);
        assertNotNull(getResponse);
    }

    @Test
    void shouldDeleteItemWhenDeletingById() {
        postItem();
        Item getByIdResponse = restTemplate.getForObject(getRootUrl() + "/getItemById?id=1", Item.class);
        assertNotNull(getByIdResponse);
        restTemplate.delete(getRootUrl() + "/deleteItem?id=1");
        try {
            getByIdResponse = restTemplate.getForObject(getRootUrl() + "/getItemById?id=1", Item.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }

    }

    private Item updateCreatedItem() {
        Item item = createItem();
        item.setId(1L);
        item.setType("Fake Fake Fake Gold");
        return item;
    }

    private ResponseEntity<Item> postItem() {
        ResponseEntity<Item> postResponse = restTemplate.postForEntity(getRootUrl() + "/addItem", createItem(), Item.class);
        return postResponse;
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
