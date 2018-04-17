package internet_shop.services;

import internet_shop.entities.Product;

import java.util.List;

public interface ProductService extends SERVICE<Product>{

    List<Product> getAll();
    //Product getByModelAndSupplier(String model, String supplier);
    Product create(Product product);
    void deleteObj(Product product);

}
