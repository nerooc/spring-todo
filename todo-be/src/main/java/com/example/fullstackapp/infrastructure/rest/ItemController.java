package com.example.fullstackapp.infrastructure.rest;

import com.example.fullstackapp.application.ItemDetails;
import com.example.fullstackapp.application.ItemService;
import com.example.fullstackapp.domain.todo.Item;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    Collection<Item> getItems() {
        return itemService.getItems();
    }

    @GetMapping(value = "/{id}")
    public Item getById(@PathVariable("id") Long id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createItem(@RequestBody @Valid ItemDetails itemDetails) {
        itemService.createItem(itemDetails);
    }

    @PutMapping("/{id}")
    void createItem(@PathVariable("id") Long id, @RequestBody @Valid ItemDetails itemDetails) {
        itemService.updateItem(itemDetails, id);
    }

    @DeleteMapping("/{id}")
    void deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
    }

}
