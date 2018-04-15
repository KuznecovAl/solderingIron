package internet_shop.dao.impl;

import internet_shop.dao.ProductDao;
import internet_shop.entities.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository()
public class ProductDaoImpl extends BaseDao<Product> implements ProductDao<Product> {

    public ProductDaoImpl(){
        super();
        clazz = Product.class;
    }

    @Override
    public List<Product> getAll() throws SQLException {
        Query query = getEm().createQuery("from Product");
        return (List<Product>) query.getResultList();
    }


}
