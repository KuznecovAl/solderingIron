package internet_shop.dao;


import internet_shop.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends DAO<User>{

    List<User> getAll() throws SQLException;
    User getByLogin(String login) throws SQLException;
    //User getByOrder(Order order) throws SQLException;



}
