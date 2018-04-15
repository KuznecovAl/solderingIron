package internet_shop.dao;


import internet_shop.entities.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao extends DAO <Order> {
    List<Order> getByUserId(Long userId) throws SQLException;
}
