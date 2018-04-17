package internet_shop;

import internet_shop.dao.UserDao;
import internet_shop.dao.impl.UserDaoImpl;
import internet_shop.entities.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ContextConfiguration("/testContext.xml")

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional()
@Commit
public class DaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void addUser() throws SQLException {
        User p = new User();
        p.setFirstname("Yuli");
        p.setLastname("Slabko");
        p.setEmail("ys@kkk.ru");
        User persistent =(User) userDao.add(p);
        assertNotNull(persistent.getId());
        persistent =(User) userDao.get(persistent.getId());
        assertEquals("User not persist", p, persistent);
        List<User> allUsers=userDao.getAll();

        for (User allUser : allUsers) {
            System.out.println(allUser);
        }
        System.out.println(userDao.getByLogin("admin"));
        userDao.delete(persistent.getId());
    }
    
//    @After
//    public void deletePerson() throws SQLException {
//        List<User> list = userDao.getAll();
//        int size = list.size();
//        if (list.size() > 0) {
//            User persistent = list.get(0);
//            userDao.delete(persistent.getId());
//            assertNotSame(userDao.getAll().size(), size);
//        }
//    }
}
