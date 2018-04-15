package internet_shop.dao;

import internet_shop.entities.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao extends DAO<Item>{
    List<Item> getByOrderId(Long orderId) throws SQLException;
}
