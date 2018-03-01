package internet_shop;


import java.io.Serializable;


public interface UserService {

    User save(User user);
    User saveNew(User user);
    User get(Serializable id);
    void update(User user);
    int delete(Serializable id);
    User getByLogin(String login);

    //List<User> getByOrderId(long productId);
}
