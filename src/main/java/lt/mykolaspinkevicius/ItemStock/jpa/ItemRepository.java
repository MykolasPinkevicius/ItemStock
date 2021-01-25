package lt.mykolaspinkevicius.ItemStock.jpa;

import lt.mykolaspinkevicius.ItemStock.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
