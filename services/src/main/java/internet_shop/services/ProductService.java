package internet_shop.services;


import internet_shop.entities.Product;

import java.io.Serializable;
import java.util.List;


public interface ProductService {

    Product save(Product product);
    Product get(Serializable id);
    void update(Product product);
    void delete(Product product);

    List<Product> getAll();
    //Product getByModelAndSupplier(String model, String supplier);

}
