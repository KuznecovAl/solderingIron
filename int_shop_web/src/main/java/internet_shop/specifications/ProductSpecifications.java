package internet_shop.specifications;

import internet_shop.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class ProductSpecifications {

    public static Specification<Product> getAllBySupplier(String supp) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("supplier"), supp);
            }
        };
    }


}
