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

        items.add(new Item(UUID.randomUUID(), "Milk", 1));
        items.add(new Item(UUID.randomUUID(), "Chicken Breast", 3));
        items.add(new Item(UUID.randomUUID(), "Fruit Storage Containers", 4));
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
    public void updateByName() {

    }

    @Override
    public void deleteByUUID() {

    }

    @Override
    public void deleteAll() {

    }
}
