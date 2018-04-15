package internet_shop.dao;

import internet_shop.entities.Product;
import lombok.NoArgsConstructor;
import javax.persistence.Query;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor
public class ProductDaoImpl extends AbstractDao implements ProductDao {

    private static volatile ProductDao INSTANCE = null;

    public static ProductDao getInstance() {
        ProductDao productDao = INSTANCE;
        if (productDao == null) {
            synchronized (ProductDaoImpl.class) {
                productDao = INSTANCE;
                if (productDao == null) {
                    INSTANCE = productDao = new ProductDaoImpl();
                }
            }
        }
        return productDao;
    }

    @Override
    public List<Product> getAll() throws SQLException {
        Query query = getEm().createQuery("from Product");
        //query.executeUpdate();
        return query.getResultList();
    }

    @Override
    public Product save(Product product) throws SQLException {
        getEm().persist(product);
        return product;
    }

    @Override
    public Product get(Serializable id) throws SQLException {
          return getEm().find(Product.class, id);
    }

    @Override
    public void update(Product product) throws SQLException {
        getEm().merge(product);
    }

    //TODO удаление по статусу
    @Override
    public void delete(Product product) throws SQLException {
        getEm().remove(product);
    }

}
