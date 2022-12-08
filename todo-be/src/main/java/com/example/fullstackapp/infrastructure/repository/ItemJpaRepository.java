package com.example.fullstackapp.infrastructure.repository;

import com.example.fullstackapp.domain.todo.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemJpaRepository extends JpaRepository<Item, Long> {

}
