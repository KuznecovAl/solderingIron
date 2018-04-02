package internet_shop;


import java.io.Serializable;
import java.util.List;


public interface OrderService {

    Order createOrder(Long userId, Long productId, Integer quantity);

    Order save(Order order);
    Order get(Serializable id);
    void update(Order order);
    void delete(Order order);

    List<Order> getByUserId(Long userId);
}
