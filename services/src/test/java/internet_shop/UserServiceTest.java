package internet_shop;


import org.junit.Test;
import java.sql.SQLException;
import java.util.List;


public class UserServiceTest {

    UserService userService = UserServiceImpl.getInstance();

    @Test
    public void serviceGetAllAndGetByLoginUserTest () throws SQLException {

        User u=userService.getByLogin("qaz");
        System.out.println(u);

        List l=userService.getAll();

        for (Object user : l) {
            System.out.println(user);
        }
    }

    @Test
    public void serviceSaveAndDeleteTest () throws SQLException {
        User u=new User();
        u.setEmail("ss@sdsd.ru");
        u=userService.save(u);
        System.out.println(u);
        userService.delete(u);
    }

    @Test
    public void serviceGetAndUpdateTest () throws SQLException {

        User u=userService.get(7L);
        u.setFirstname("dsa");
        u.setEmail("ss876gfhgkhkh@sdsd.ru");
        userService.update(u);
        System.out.println(u);
    }




}
