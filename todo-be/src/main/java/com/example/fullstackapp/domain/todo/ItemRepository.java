package com.example.fullstackapp.domain.todo;

import java.util.Collection;
import java.util.Optional;

import jakarta.validation.constraints.NotNull;

public interface ItemRepository {
    Collection<Item> listAll();

    Optional<Item> findById(@NotNull Long id);

    Item save(@NotNull Item item);

    void delete(@NotNull Long id);
}
