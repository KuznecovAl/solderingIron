package internet_shop;

import java.io.Serializable;
import java.sql.SQLException;

public class UserServiceImpl extends AbstractService implements UserService {
    private static volatile UserService INSTANCE = null;
    private UserDao userDao = UserDaoImpl.getInstance();

    public static UserService getInstance() {
        UserService userService = INSTANCE;
        if (userService == null) {
            synchronized (UserServiceImpl.class) {
                userService = INSTANCE;
                if (userService == null) {
                    INSTANCE = userService = new UserServiceImpl();
                }
            }
        }

        return userService;
    }


    @Override
    public User save(User user) {
        try {
            startTransaction();
            user = userDao.save(user);
            commit();
        } catch (SQLException e) {
            throw new ServiceException("Error creating Item" + user);
        }
        return user;
    }

    @Override
    public User saveNew(User user) {
        try {
            startTransaction();
            user = userDao.saveNew(user);
            commit();
        } catch (SQLException e) {
            throw new ServiceException("Error creating Item" + user);
        }
        return user;
    }

    @Override
    public User get(Serializable id) {
        try {
            return userDao.get(id);
        } catch (SQLException e) {
            throw new ServiceException("Error geting Item by id " + id);
        }
    }

    @Override
    public void update(User user) {
        try {
            startTransaction();
            userDao.update(user);
            commit();
        } catch (SQLException e) {
            throw new ServiceException("Error updating Item" + user);
        }
    }

    @Override
    public int delete(Serializable id) {
        return 0;
    }

    @Override
    public User getByLogin(String login) {
        try {
            return userDao.getByLogin(login);
        } catch (SQLException e) {
            throw new ServiceException("Error getting User by login" + login);
        }
    }


//    @Override
//    public List<User> getByOrderId(long orderId) {
//        try {
//            return userDao.getByOrderId(orderId);
//        } catch (SQLException e) {
//            throw new ServiceException("Error getting all items");
//        }
//    }
}
