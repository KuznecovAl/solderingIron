package internet_shop.repository;

import internet_shop.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> getByOrderId(Long id);
}
