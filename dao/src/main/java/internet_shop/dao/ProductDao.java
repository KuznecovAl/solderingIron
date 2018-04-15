package internet_shop.dao;



import java.sql.SQLException;
import java.util.List;


public interface ProductDao<T> extends DAO<T> {

    List<T> getAll() throws SQLException;
    //List<Product> getByOrder() throws SQLException;
    //List<Product> getPopular() throws SQLException;
    //Product getByModelAndSupplier(String model, String supplier) throws SQLException;


}
