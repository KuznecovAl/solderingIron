package internet_shop;

import internet_shop.entities.User;
import internet_shop.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ContextConfiguration("/testContext.xml")

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Commit
public class ServiceTest {

    @Autowired
    private UserService userSrv;

    @Test
    public void addUser() {
        User p = new User();
        p.setFirstname("Yuli");
        p.setLastname("Slabko");
        p.setEmail("ys@kkk.ru");
        User persistent = userSrv.create(p);
        assertNotNull(persistent.getId());
        persistent = userSrv.get(persistent.getId());
        assertEquals("User not persist", p, persistent);

        List<User> allUsers=userSrv.getAll();

        for (User allUser : allUsers) {
            System.out.println(allUser);
        }
        System.out.println(userSrv.getByLogin("admin"));
        userSrv.deleteId(persistent.getId());
    }


//    @After
//    public void deletePerson() throws SQLException {
//        List<User> list = userSrv.getAll();
//        int size = list.size();
//        if (list.size() > 0) {
//            User persistent = list.get(0);
//            userSrv.delete(persistent.getId());
//            assertNotSame(userSrv.getAll().size(), size);
//        }
//    }
}
