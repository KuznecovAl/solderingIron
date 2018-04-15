package internet_shop.dao;


import internet_shop.entities.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao extends DAO<Product>{

    List<Product> getAll() throws SQLException;
    //List<Product> getByOrder() throws SQLException;
    //List<Product> getPopular() throws SQLException;
    //Product getByModelAndSupplier(String model, String supplier) throws SQLException;


}
