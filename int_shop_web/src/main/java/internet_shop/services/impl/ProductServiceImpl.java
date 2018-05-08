package internet_shop.services.impl;

import internet_shop.entities.Product;
import internet_shop.repository.ProductRepository;
import internet_shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllbySupplier(){return productRepository.findAll(byS)}

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) {
       return productRepository.saveAndFlush(product);
    }

    public void deleteObj(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void add(Product product) {
        productRepository.saveAndFlush(product);
    }

    @Override
    public void update(Product product) {
        productRepository.saveAndFlush(product);
    }

    @Override
    public Product get(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteId(Long id) {
        productRepository.deleteById(id);
    }

}
