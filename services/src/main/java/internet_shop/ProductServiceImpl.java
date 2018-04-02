package internet_shop;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;


public class ProductServiceImpl implements ProductService {

    private static volatile ProductService INSTANCE = null;
    private ProductDao productDao = ProductDaoImpl.getInstance();

    public static ProductService getInstance() {
        ProductService productService = INSTANCE;
        if (productService == null) {
            synchronized (ProductServiceImpl.class) {
                productService = INSTANCE;
                if (productService == null) {
                    INSTANCE = productService = new ProductServiceImpl();
                }
            }
        }
        return productService;
    }

    @Override
    public List<Product> getAll() {
        try {
            productDao.openEm();
            List res = productDao.getAll();
            productDao.closeEm();
            return res;
        } catch (SQLException e) {
            throw new ServiceException("Error getting all Products");
        }
    }
    @Override
    public Product save(Product product) {
        try {
            productDao.openEmTransact();
            product = productDao.save(product);
            productDao.closeEmTransact();
        } catch (SQLException e) {
            throw new ServiceException("Error creating Product " + product);
        }
        return product;
    }
    @Override
    public Product get(Serializable id) {
        try {
            productDao.openEm();
            Product product = productDao.get(id);
            productDao.closeEm();
            return product;
        } catch (SQLException e) {
            throw new ServiceException("Error getting User by id " + id);
        }
    }
    @Override
    public void update(Product product) {
        try {
            productDao.openEmTransact();
            productDao.update(product);
            productDao.closeEmTransact();
        } catch (SQLException e) {
            throw new ServiceException("Error updating Product " + product);
        }
    }
    @Override
    public void delete(Product product) {
        try {
            productDao.openEmTransact();
            productDao.delete(product);
            productDao.closeEmTransact();
        } catch (SQLException e) {
            throw new ServiceException("Error deleting Product " + product);
        }
    }


}
