package com.homeuse.needtobuy.dao;

import com.homeuse.needtobuy.model.Item;

import java.util.List;
import java.util.UUID;

public interface ItemDAO {

    List<Item> getAll();
    void insertItem(String name, int quantity);
    void updateItem(Item item);
    void deleteByUUID(UUID uuid);
    void deleteAll();
}
