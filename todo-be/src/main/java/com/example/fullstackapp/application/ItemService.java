package com.example.fullstackapp.application;

import java.util.Collection;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;

import com.example.fullstackapp.domain.TimeService;
import com.example.fullstackapp.domain.todo.Item;
import com.example.fullstackapp.domain.todo.ItemNotFoundException;
import com.example.fullstackapp.domain.todo.ItemRepository;

// SLF4J for loggin purposes
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;
    private final TimeService timeService;

    public Collection<Item> getItems() {
        log.info("Gathering all available items!");
        return itemRepository.listAll();
    }

    public Item getItemById(@NotNull Long id) {
        log.info("Gathering single item of ID = <{}>", id);
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    public void createItem(@NotNull ItemDetails itemDetails) {
        log.info("Creating single item of ID = <{}>", itemDetails);

        final Item item = Item.builder()
                .title(itemDetails.title())
                .content(itemDetails.content())
                .currentTime(timeService.getZonedDateTime())
                .build();

        final Item createdItem = itemRepository.save(item);

        log.info("New item created properly = <{}>", createdItem);
    }

    public void updateItem(@NotNull ItemDetails request, @NotNull Long id) {
        log.info("Updating single item of ID = <{}>", id);

        final Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        item.setCompleted(request.completed());
        item.setTitle(request.title());
        item.setContent(request.content());
        item.setUpdateDate(timeService.getZonedDateTime());

        log.info("New item of ID = <{}>  updated properly", item);
    }

    public void deleteItem(@NotNull Long id) {
        log.info("Deleting single item od ID = <{}>", id);

        itemRepository.delete(id);

        log.info("Item of ID = <{}> deleted properly", id);
    }

}
