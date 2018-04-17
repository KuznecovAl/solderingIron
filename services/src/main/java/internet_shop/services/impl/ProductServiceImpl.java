package internet_shop.services.impl;

import internet_shop.dao.ProductDao;
import internet_shop.entities.Product;
import internet_shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    ProductDao productDao;

    public List<Product> getAll() {
        try {
            return productDao.getAll();
        } catch (SQLException e) {
            throw new ServiceException("Error getting all Products");
        }
    }

    public Product create(Product product) {
        if (product != null) {
            return (Product) productDao.add(product);
        }
        return product;
    }

    public void deleteObj(Product product) {
        if (product != null) {
            productDao.delete(product.getId());
        }
    }

    @Override
    public void add(Product product) {
        productDao.add(product);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public Product get(Serializable id) {
        return (Product) productDao.get(id);
    }

    @Override
    public void deleteId(Serializable id) {
        productDao.delete(id);
    }
}
