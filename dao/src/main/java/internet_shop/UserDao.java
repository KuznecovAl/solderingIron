package internet_shop;


import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public interface UserDao extends DAO<User>{

    List<User> getAll() throws SQLException;
    User getByLogin(String login) throws SQLException;
    //User getByOrder(Order order) throws SQLException;



}
