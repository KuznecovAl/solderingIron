package internet_shop;

import org.junit.Assert;


public class EntitiesTest {


    @org.junit.Test
    public void entitiesTest() {

        Item i=new Item();
        Product p=new Product();
        Order o =new Order();
        User u=new User();



        if (i==null|p==null|o==null|u==null)
        {
            Assert.assertEquals(1, 0);
        } else {
            Assert.assertEquals(1, 1);
        }
    }


}
