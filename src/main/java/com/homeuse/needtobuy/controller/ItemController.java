package com.homeuse.needtobuy.controller;

import com.homeuse.needtobuy.model.Item;
import com.homeuse.needtobuy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return this.itemService.getItems();
    }

    @PostMapping("/items")
    public void addItem(@NonNull @RequestBody Item item) {
        this.itemService.insertItem(item);
    }

}
