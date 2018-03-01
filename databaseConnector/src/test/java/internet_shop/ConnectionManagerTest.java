package internet_shop;

import org.junit.Assert;

import java.sql.Connection;


public class ConnectionManagerTest {


    @org.junit.Test
    public void returnConnection() {


        if (ConnectionManager.getConnection() == null)
        {
            Assert.assertEquals(1, 0);
        } else {
            Assert.assertEquals(1, 1);
        }
    }


}
