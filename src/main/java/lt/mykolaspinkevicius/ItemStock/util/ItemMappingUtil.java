package lt.mykolaspinkevicius.ItemStock.util;

import lt.mykolaspinkevicius.ItemStock.entity.Item;

public class ItemMappingUtil {
    public static void updateItem(Item result, Item source) {
        result.setCreated(source.getCreated());
        result.setId(source.getId());
        result.setQuantity(source.getQuantity());
        result.setType(source.getType());
        result.setValidUntil(source.getValidUntil());
    }
}
