package lt.mykolaspinkevicius.ItemStock.mappers;

import lt.mykolaspinkevicius.ItemStock.entity.Item;

public class MapItemToItem {
    public static void mapItemToItem(Item result, Item source) {
        result.setCreated(source.getCreated());
        result.setId(source.getId());
        result.setQuantity(source.getQuantity());
        result.setType(source.getType());
        result.setValidUntil(source.getValidUntil());
    }
}
