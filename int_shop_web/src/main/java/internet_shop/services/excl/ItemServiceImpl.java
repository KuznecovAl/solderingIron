package internet_shop.services.impl;

import internet_shop.dao.ItemDao;
import internet_shop.entities.Item;
import internet_shop.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Override
    public List<Item> getByOrderId(Long itemId) {
        try {
            return itemDao.getByOrderId(itemId);
        } catch (SQLException e) {
            throw new ServiceException("Error getting all Items");
        }
    }

    @Override
    public Item create(Item item) {
        if (item != null) {
            return (Item) itemDao.add(item);
        }
        return item;
    }

    @Override
    public void deleteObj(Item item) {
        if (item != null) {
            itemDao.delete(item.getId());
        }
    }
   
    @Override
    public void add(Item item) {
        itemDao.add(item);
    }

    @Override
    public void update(Item item) {
        itemDao.update(item);
    }

    @Override
    public Item get(Long id) {
        return (Item) itemDao.get(id);
    }

    @Override
    public void deleteId(Long id) {
        itemDao.delete(id);
    }
}
