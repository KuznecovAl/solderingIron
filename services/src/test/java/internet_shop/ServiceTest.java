package internet_shop;

import org.junit.Assert;

import java.sql.SQLException;


public class ServiceTest {

    UserService userService = UserServiceImpl.getInstance();

    @org.junit.Test
    public void DaoUserTest () throws SQLException {

        User user=userService.get(1007L);

        Assert.assertEquals(user.getClass(), User.class);



    }


}
