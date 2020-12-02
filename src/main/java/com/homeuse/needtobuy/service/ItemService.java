package com.homeuse.needtobuy.service;

import com.homeuse.needtobuy.dao.ItemDAO;
import com.homeuse.needtobuy.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ItemService {

    private final ItemDAO itemDAO;

    @Autowired
    public ItemService(@Qualifier("Local") ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public List<Item> getItems() {
        return itemDAO.getAll();
    }

    public void insertItem(Item item) {
        this.itemDAO.insertItem(item.getName(), item.getQuantity());
    }

    public void updateItem(Item item) {
        this.itemDAO.updateItem(item);
    }

    public void deleteByUUID(UUID uuid) {
        this.itemDAO.deleteByUUID(uuid);
    }

    public void deleteAll() {
        this.itemDAO.deleteAll();
    }


}
