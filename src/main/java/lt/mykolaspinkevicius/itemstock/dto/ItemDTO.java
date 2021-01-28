package lt.mykolaspinkevicius.itemstock.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ItemDTO implements Serializable {

    private Long id;
    private String type;
    private Long quantity;
    private LocalDate created;
    private LocalDate validUntil;

    public ItemDTO(Long id, String type, Long quantity, LocalDate created, LocalDate validUntil) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
        this.created = created;
        this.validUntil = validUntil;
    }

    public ItemDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return Objects.equals(id, itemDTO.id) && Objects.equals(type, itemDTO.type) && Objects.equals(created, itemDTO.created) && Objects.equals(validUntil, itemDTO.validUntil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, created, validUntil);
    }
}
