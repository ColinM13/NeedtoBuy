package com.homeuse.needtobuy.model;

import org.springframework.lang.NonNull;

import java.util.UUID;

public class Item {

    private UUID uuid;
    @NonNull
    private String name;
    @NonNull
    private int quantity;

    public Item(UUID uuid, String name, int quantity) {
        this.uuid = uuid;
        this.name = name;
        this.quantity = quantity;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
