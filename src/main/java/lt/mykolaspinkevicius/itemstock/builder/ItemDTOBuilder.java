package lt.mykolaspinkevicius.itemstock.builder;

import lt.mykolaspinkevicius.itemstock.dto.ItemDTO;
import lt.mykolaspinkevicius.itemstock.entity.Item;

import java.time.LocalDate;

public class ItemDTOBuilder {
    private Long id;
    private String type;
    private Long quantity;
    private LocalDate created;
    private LocalDate validUntil;

    public ItemDTOBuilder() {}

    public ItemDTOBuilder setItemDTO(Item item) {
        this.id = item.getId();
        this.created = item.getCreated();
        this.quantity = item.getQuantity();
        this.type = item.getType();
        this.validUntil = item.getValidUntil();
        return this;
    }
    public ItemDTO build() {
        return new ItemDTO(id, type, quantity, created, validUntil);
    }

}
