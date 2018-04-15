package internet_shop.dao;

import internet_shop.entities.Item;
import internet_shop.entities.Order;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.*;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor
public class ItemDaoImpl extends AbstractDao implements ItemDao {

    private static volatile ItemDao INSTANCE = null;
    
    public static ItemDao getInstance() {
        ItemDao itemDao = INSTANCE;
        if (itemDao == null) {
            synchronized (ItemDaoImpl.class) {
                itemDao = INSTANCE;
                if (itemDao == null) {
                    INSTANCE = itemDao = new ItemDaoImpl();
                }
            }
        }

        return itemDao;
    }

    @Override
    public Item save(Item item) throws SQLException {
        getEm().persist(item);
        return item;
    }

    @Override
    public Item get(Serializable id) throws SQLException {
        return getEm().find(Item.class, id);
    }

    @Override
    public void update(Item item) throws SQLException {
        getEm().merge(item);
    }

    @Override
    public void delete(Item item) throws SQLException {
        getEm().remove(item);
    }


    @Override
    public List<Item> getByOrderId(Long orderId) throws SQLException {
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<Item> criteria = cb.createQuery(Item.class);
        Root<Item> itemRoot = criteria.from(Item.class);
        Join<Item, Order> orderJoin = itemRoot.join("id", JoinType.INNER);
        criteria.where(cb.equal(orderJoin.get("id"), orderId));
        return getEm().createQuery(criteria).getResultList();
    }

}
