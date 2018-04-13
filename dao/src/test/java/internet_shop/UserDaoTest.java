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
        OrderDao od=OrderDaoImpl.getInstance();
        ud.openEmTransact();


        Address address = new Address("Belarus", "Minsk", "Germanovskaya", "17", "107", "220028");
        User user = new User( "Kozma", "pass", "7515313@mail.ru", address);

        Order order = od.get(1L);


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
            System.out.println(u.getOrders().get(0).toString());
            System.out.println(u.getOrders().get(0).getItems().get(0).toString());


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
