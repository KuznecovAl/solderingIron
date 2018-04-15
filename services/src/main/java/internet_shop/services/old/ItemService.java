package internet_shop.services.old;


import internet_shop.entities.Item;

import java.io.Serializable;
import java.util.List;


public interface ItemService {

    Item save(Item item);
    Item get(Serializable id);
    void update(Item item);
    void delete(Item item);



    List<Item> getByOrderId(Long orderId);

}
