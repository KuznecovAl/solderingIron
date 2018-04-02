package internet_shop;


import java.io.Serializable;
import java.util.List;


public interface ItemService {

    Item save(Item item);
    Item get(Serializable id);
    void update(Item item);
    void delete(Item item);



    List<Item> getByOrderId(Long orderId);

}
