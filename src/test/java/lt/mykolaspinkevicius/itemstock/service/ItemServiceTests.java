package lt.mykolaspinkevicius.itemstock.service;

import lt.mykolaspinkevicius.itemstock.entity.Item;
import lt.mykolaspinkevicius.itemstock.repository.ItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTests {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    private Long id;
    private Item item;
    private String type;
    private Long quantity;
    private LocalDate validDate = LocalDate.now();

    @Before
    public void setup() {
        id = 1L;
        item = new Item();
        item.setId(id);
        type = "nothing";
        quantity = id;
    }

    @Test
    public void shouldReturnItemWhenGettingItemByIdIt() {
        when(itemRepository.findById(any(Long.class))).thenReturn(Optional.of(item));
        itemService.getItemById(id);
        verify(itemRepository, times(1)).findById(id);
    }

    @Test
    public void shouldCallMethodOnceWhenCreatingItem() {
        itemService.save(item);
        verify(itemRepository, times(1)).save(item);
    }

    @Test
    public void shouldCallTwoMethodsOnceWhenDeletingItem() {
        when(itemRepository.findById(id)).thenReturn(Optional.of(item));
        itemService.delete(id);
        verify(itemRepository, times(1)).findById(item.getId());
        verify(itemRepository, times(1)).delete(item);
    }

    @Test
    public void shouldCallMethodOnceWhenUpdatingItem() {
        itemService.update(item);
        verify(itemRepository, times(1)).save(item);
    }

    @Test
    public void shouldCallMethodOnceWhenGettingAllItems() {
        itemService.getAllItems();
        verify(itemRepository, times(1)).findAll();
    }

    @Test
    public void shouldCallMethodOnceWhenGettingItemsWithProvidedAvailableQuantityAndType() {
        itemService.getItemsWithProvidedAvailableQuantityAndType(type, quantity);
        verify(itemRepository, times(1)).findWithProvidedAvailableQuantityAndType(type, quantity);
    }

    @Test
    public void shouldCallMethodOnceWhenGettingItemsWithValidDate() {
        itemService.getItemsWithValidDate(validDate);
        verify(itemRepository, times(1)).findWithValidDate(validDate);
    }
}
