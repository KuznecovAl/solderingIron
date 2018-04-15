package internet_shop.dao;


import java.sql.SQLException;
import java.util.List;


public interface OrderDao<T> extends DAO<T> {

    List<T> getByUserId(Long userId) throws SQLException;


}
