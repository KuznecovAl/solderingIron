package internet_shop.services.old;

import internet_shop.dao.old.ItemDao;
import internet_shop.dao.old.ItemDaoImpl;
import internet_shop.entities.Item;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;


public class ItemServiceImpl implements ItemService {

    private static volatile ItemService INSTANCE = null;
    private ItemDao itemDao = ItemDaoImpl.getInstance();

    public static ItemService getInstance() {
        ItemService itemService = INSTANCE;
        if (itemService == null) {
            synchronized (ItemDaoImpl.class) {
                itemService = INSTANCE;
                if (itemService == null) {
                    INSTANCE = itemService = new ItemServiceImpl();
                }
            }
        }
        return itemService;
    }

    @Override
    public List<Item> getByOrderId(Long orderId) {
        try {
            itemDao.openEm();
            List res = itemDao.getByOrderId(orderId);
            itemDao.closeEm();
            return res;
        } catch (SQLException e) {
            throw new ServiceException("Error getting items by order id");
        }
    }

    @Override
    public Item save(Item item) {
        try {
            itemDao.openEmTransact();
            item = itemDao.save(item);
            itemDao.closeEmTransact();
        } catch (SQLException e) {
            throw new ServiceException("Error creating Item " + item);
        }
        return item;
    }

    @Override
    public Item get(Serializable id) {
        try {
            itemDao.openEm();
            Item item = itemDao.get(id);
            itemDao.closeEm();
            return item;
        } catch (SQLException e) {
            throw new ServiceException("Error getting Item by id " + id);
        }
    }

    @Override
    public void update(Item item) {
        try {
            itemDao.openEmTransact();
            itemDao.update(item);
            itemDao.closeEmTransact();
        } catch (SQLException e) {
            throw new ServiceException("Error updating Item " + item);
        }
    }

    @Override
    public void delete(Item item) {
        try {
            itemDao.openEmTransact();
            itemDao.delete(item);
            itemDao.closeEmTransact();
        } catch (SQLException e) {
            throw new ServiceException("Error deleting Item " + item);
        }
    }


}
