package internet_shop.dao.impl;

import internet_shop.dao.ItemDao;
import internet_shop.entities.Item;
import internet_shop.entities.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemDaoImpl extends BaseDao<Item> implements ItemDao<Item> {

    public ItemDaoImpl(){
        super();
        clazz = Item.class;
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
