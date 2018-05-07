package internet_shop.services;

import internet_shop.entities.Item;

import java.util.List;

public interface ItemService extends SERVICE<Item>{

    Item create(Item item);
    void deleteObj(Item item);
    List<Item> getByOrderId(Long orderId);

}
