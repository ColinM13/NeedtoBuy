package com.homeuse.needtobuy.controller;

import com.homeuse.needtobuy.model.Item;
import com.homeuse.needtobuy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @PutMapping("/items")
    public void updateItem(@NonNull @RequestBody Item item) {
        this.itemService.updateItem(item);
    }

    @DeleteMapping("/items/{uuid}")
    public void deleteByUUID(@PathVariable("uuid") UUID uuid) {
        this.itemService.deleteByUUID(uuid);
    }

    @DeleteMapping("/items/delete")
    public void deleteAll() {
        this.itemService.deleteAll();
    }
}
