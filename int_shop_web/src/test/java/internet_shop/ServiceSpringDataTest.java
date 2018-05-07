package internet_shop;

import internet_shop.config.DataConfig;
import internet_shop.services.UserService;
import internet_shop.entities.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
@WebAppConfiguration
@Commit
public class ServiceSpringDataTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private UserService userSrv;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void addUser() {
        User p = new User();
        p.setFirstname("Yuli");
        p.setLastname("Slabko");
        p.setEmail("ys@kkk.ru");
        User persistent = userSrv.create(p);
        assertNotNull(persistent.getId());
        User persistent2 = userSrv.get(persistent.getId());
        assertEquals("User not persist", p, persistent);

        List<User> allUsers=userSrv.getAll();

        for (User allUser : allUsers) {
            System.out.println(allUser);
        }
        System.out.println(userSrv.getByLogin("admin"));
        userSrv.deleteId(persistent2.getId());
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
