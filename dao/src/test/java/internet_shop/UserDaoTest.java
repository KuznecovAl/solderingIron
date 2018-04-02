package internet_shop;


import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class UserDaoTest {
    @Before
    public void init() throws SQLException {
        UserDao ud = UserDaoImpl.getInstance();
        ud.openEmTransact();

        Address address = new Address("Belarus", "Minsk", "Germanovskaya", "17", "107", "220028");
        User user = new User(null, "Kozma", "pass", "Alexandr", "Kuznecov", "0", "7515313@gmail.com", "+375297515313",
                address, "RU", "new", LocalDate.parse("1983-11-26"), new ArrayList<>(), null);
        Order order = new Order(null, null, "xxx", user, null);


        ud.save(user);

        user.getOrders().add(order);


        ud.closeEmTransact();

    }

    @Test
    public void userDaoTest() {

        UserDao ud = UserDaoImpl.getInstance();


        try {
            ud.openEm();
            User u = ud.getByLogin("Kozma");
            System.out.println(u.toString());


            ud.getEm().getTransaction().begin();

                u.getOrders().get(0).setStatus("new status");
                ud.update(u);

            ud.closeEmTransact();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    @AfterClass
    public static void cleanUp() {
        AbstractDao.closeEMFactory();
    }
}
