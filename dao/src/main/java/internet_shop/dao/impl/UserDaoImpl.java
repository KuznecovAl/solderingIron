package internet_shop.dao.impl;

import internet_shop.dao.UserDao;
import internet_shop.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.List;

@Repository()
public class UserDaoImpl extends BaseDao<User> implements UserDao<User> {

    public UserDaoImpl(){
        super();
        clazz = User.class;
    }


    @Override
    public List<User> getAll() throws SQLException {
        Query query = getEm().createQuery("from User");
        return (List<User>) query.getResultList();
    }

    @Override
    public User getByLogin(String login) throws SQLException {
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> userRoot = criteria.from(User.class);
        criteria.where(cb.equal(userRoot.get("login"), login));
        try {
            return getEm().createQuery(criteria).getResultList().get(0);
        } catch (IndexOutOfBoundsException sss) {
            return null;
        }
    }
}
