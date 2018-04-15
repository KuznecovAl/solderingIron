package internet_shop.services;


import internet_shop.dao.UserDao;
import internet_shop.dao.UserDaoImpl;
import internet_shop.entities.User;
import lombok.Getter;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;


public class UserServiceImpl implements UserService {

    private static volatile UserService INSTANCE = null;
    @Getter
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
            userDao.openEmTransact();
            user = userDao.save(user);
            userDao.closeEmTransact();
        } catch (SQLException e) {
            throw new ServiceException("Error creating User " + user);
        }
        return user;
    }
    @Override
    public User get(Serializable id) {
        try {
            userDao.openEm();
            User user = userDao.get(id);
            userDao.closeEm();
            return user;
        } catch (SQLException e) {
            throw new ServiceException("Error getting User by id " + id);
        }
    }
    @Override
    public void update(User user) {
        try {
            userDao.openEmTransact();
            userDao.update(user);
            userDao.closeEmTransact();
        } catch (SQLException e) {
            throw new ServiceException("Error updating User " + user);
        }
    }
    @Override
    public void delete(User user) {
        try {
            userDao.openEmTransact();
            userDao.delete(user);
            userDao.closeEmTransact();
        } catch (SQLException e) {
            throw new ServiceException("Error deleting User " + user);
        }
    }
    @Override
    public List<User> getAll(){
        try {
            userDao.openEm();
            List res = userDao.getAll();
            userDao.closeEm();
            return res;
        } catch (SQLException e) {
            throw new ServiceException("Error getting all User");
        }
    }
    @Override
    public User getByLogin(String login) {
        try {
            userDao.openEm();
            User user = userDao.getByLogin(login);
            userDao.closeEm();
            return user;
        } catch (SQLException e) {
            throw new ServiceException("Error geting User by login " + login);
        }
    }
}
