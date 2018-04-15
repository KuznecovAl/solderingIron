package internet_shop.dao;

import java.sql.SQLException;
import java.util.List;


public interface ItemDao<T> extends DAO<T> {

    List<T> getByOrderId(Long orderId) throws SQLException;


}
