package internet_shop.dao;


import java.sql.SQLException;
import java.util.List;


public interface UserDao<T> extends DAO<T> {

    List<T> getAll() throws SQLException;
    T getByLogin(String login) throws SQLException;
    //T getByOrder(Order order) throws SQLException;


}
