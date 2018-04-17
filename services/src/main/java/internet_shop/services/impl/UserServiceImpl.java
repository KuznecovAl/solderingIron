package internet_shop.services.impl;

import internet_shop.dao.UserDao;
import internet_shop.entities.User;
import internet_shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getByLogin(String login) {
        try {
            return (User) userDao.getByLogin(login);
        } catch (SQLException e) {
            throw new ServiceException("Error getting User by login " + login);
        }
    }

    @Override
    public List<User> getAll() {
        try {
            return userDao.getAll();
        } catch (SQLException e) {
            throw new ServiceException("Error getting all Users");
        }
    }

    @Override
    public User create(User user) {
        if (user != null) {
            return (User) userDao.add(user);
        }
        return user;
    }

    @Override
    public void deleteObj(User user) {
        if (user != null) {
            userDao.delete(user.getId());
        }
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User get(Serializable id) {
        return (User) userDao.get(id);
    }

    @Override
    public void deleteId(Serializable id) {
        userDao.delete(id);
    }
}


