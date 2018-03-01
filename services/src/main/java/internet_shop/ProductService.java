package internet_shop;


import java.io.Serializable;
import java.util.List;


public interface ProductService {

    Product save(Product product);

    Product get(Serializable id);

    void update(Product product);

    int delete(Serializable id);
    List<Product> getAll();
    Product getByModelAndSupplier(String model, String supplier);

}
