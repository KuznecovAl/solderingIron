package internet_shop.services;

import internet_shop.entities.User;

import java.util.List;

public interface UserService extends SERVICE<User> {

    List<User> getAll();
    User getByLogin(String login);
    User create(User user);
    void deleteObj(User user);

}
