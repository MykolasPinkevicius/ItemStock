package lt.mykolaspinkevicius.itemstock.repository;

import lt.mykolaspinkevicius.itemstock.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {

    @Query("select i from Item i where i.validUntil < ?1")
    List<Item> findWithValidDate(LocalDate validUntil);

    @Query("select i from Item i where i.type = ?1 and i.quantity < ?2")
    List<Item> findWithProvidedAvailableQuantityAndType(String type, Long quality);
}
