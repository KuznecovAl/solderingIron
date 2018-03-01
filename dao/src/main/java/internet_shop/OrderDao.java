package internet_shop;


import java.sql.SQLException;
import java.util.List;

public interface OrderDao extends DAO <Order> {
    List<Order> getByUserId(long userId) throws SQLException;
}
