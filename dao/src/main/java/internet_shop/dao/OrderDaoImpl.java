package internet_shop.dao;

import internet_shop.entities.Order;
import internet_shop.entities.User;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.*;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor
public class OrderDaoImpl extends AbstractDao implements OrderDao {
    private static volatile OrderDao INSTANCE = null;
    
    public static OrderDao getInstance() {
        OrderDao orderDao = INSTANCE;
        if (orderDao == null) {
            synchronized (OrderDaoImpl.class) {
                orderDao = INSTANCE;
                if (orderDao == null) {
                    INSTANCE = orderDao = new OrderDaoImpl();
                }
            }
        }
        return orderDao;
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


    @Override
    public Order save(Order order) throws SQLException {
        getEm().persist(order);
        return order;
    }

    @Override
    public Order get(Serializable id) throws SQLException {
        return getEm().find(Order.class, id);
    }

    @Override
    public void update(Order order) throws SQLException {
        getEm().merge(order);
    }

    @Override
    public void delete(Order order) throws SQLException {
        getEm().remove(order);
    }



}
