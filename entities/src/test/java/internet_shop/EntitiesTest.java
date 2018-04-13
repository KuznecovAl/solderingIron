package internet_shop;

import org.junit.Assert;

import java.util.ArrayList;


public class EntitiesTest {


    @org.junit.Test
    public void entitiesTest() {

        Address a=new Address();
        Item i=new Item();
        Product p=new Product();
        Order o =new Order();
        User u=new User();

        Address aa=new Address("1","2","3","4","5","6");

        a.setBuilding("25");
        i.setDiscount(10);
        p.setDescription("xxx");
        o.setUser(u);
        u.setOrders(new ArrayList<>());
        u.getOrders().add(o);

        boolean x =aa.hashCode()==a.hashCode();
        System.out.println(x);

        if (a==null|i==null|p==null|o==null|u==null)
        {
            Assert.assertEquals(1, 0);
        } else {
            Assert.assertEquals(1, 1);
        }
    }


}
