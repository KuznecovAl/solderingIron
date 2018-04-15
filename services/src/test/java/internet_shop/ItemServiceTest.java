package internet_shop;


import internet_shop.services.ItemService;
import internet_shop.services.ItemServiceImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class ItemServiceTest {

    ItemService itemService = ItemServiceImpl.getInstance();

    @Test
    public void getByOrderIdItemTest () throws SQLException {


        List res=itemService.getByOrderId(10L);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }


    }






}
