package internet_shop.dao.impl;

import internet_shop.dao.OrderDao;
import internet_shop.entities.Order;
import internet_shop.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.sql.SQLException;
import java.util.List;

@Repository()
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao<Order> {

    public OrderDaoImpl(){
        super();
        clazz = Order.class;
    }

    @Override
    public List<Order> getByUserId(Long userId) throws SQLException {

        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<Order> criteria = cb.createQuery(Order.class);
        Root<Order> orderRoot = criteria.from(Order.class);
        Join<Order, User> userJoin = orderRoot.join("id", JoinType.INNER);
        criteria.where(cb.equal(userJoin.get("id"), userId));
        return getEm().createQuery(criteria).getResultList();

    }

}
