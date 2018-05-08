package internet_shop.services.impl;

import internet_shop.entities.User;
import internet_shop.repository.UserRepository;
import internet_shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


@Autowired
    private UserRepository userRepository;

    @Override
    public User getByLogin(String login) {
       return userRepository.getByLogin(login);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
    @Override
    public User create(User user) {
        user=userRepository.saveAndFlush(user);
        return user;
    }

    @Override
    public void deleteObj(User user) {
        userRepository.delete(user);
    }

    @Override
    public void add(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void update(User user) {
        userRepository.saveAndFlush(user);
    }


    @Override
    public User get(Long id) {
        return (userRepository.findById(id)).get();
    }

    @Override
    public void deleteId(Long id) {
        userRepository.deleteById(id);
    }
}


