package internet_shop.services.impl;

import internet_shop.entities.Item;
import internet_shop.repository.ItemRepository;
import internet_shop.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;


    @Override
    public List<Item> getByOrderId(Long id) {
        return itemRepository.getByOrderId(id);
    }

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public Item create(Item item) {
        return itemRepository.saveAndFlush(item);
    }

    public void deleteObj(Item item) {
        itemRepository.delete(item);
    }

    @Override
    public void add(Item item) {
        itemRepository.saveAndFlush(item);
    }

    @Override
    public void update(Item item) {
        itemRepository.saveAndFlush(item);
    }

    @Override
    public Item get(Long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public void deleteId(Long id) {
        itemRepository.deleteById(id);
    }
    
    
    
}
