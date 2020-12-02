package com.homeuse.needtobuy.dao;

import com.homeuse.needtobuy.model.Item;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Qualifier("Local")
public class LocalItemDAO implements ItemDAO {

    private List<Item> items;

    public LocalItemDAO() {
        this.items = new ArrayList<>();

        items.add(new Item(UUID.fromString("38684009-ef7a-4788-a534-e74e55a48b9b"), "Milk", 1));
        items.add(new Item(UUID.randomUUID(), "Chicken Breast", 3));
        items.add(new Item(UUID.randomUUID(), "Fruit Storage Containers", 4));
        items.add(new Item(UUID.fromString("ab88445f-0d6e-49be-a4d6-93ecba16bb8f"), "PS5", 1));
    }

    @Override
    public List<Item> getAll() {
        return this.items;
    }

    @Override
    public void insertItem(String name, int quantity) {
        items.add(new Item(UUID.randomUUID(), name, quantity));
    }

    @Override
    public void updateItem(Item item) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getUuid().equals(item.getUuid())) {
                items.get(i).setQuantity(item.getQuantity());
                items.get(i).setName(item.getName());
                break;
            }
        }
    }

    @Override
    public void deleteByUUID(UUID uuid) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getUuid().equals(uuid)) {
                items.remove(i);
                break;
            }
        }
    }

    @Override
    public void deleteAll() {
        this.items.clear();
    }
}
