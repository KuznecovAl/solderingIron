package internet_shop;


import java.io.Serializable;
import java.util.List;


public interface UserService {

    User save(User user);
    User get(Serializable id);
    void update(User user);
    void delete(User user);

    //доступ к EM из сервисов
    //UserDao getUserDao();

    List<User> getAll();
    User getByLogin(String login);

}
