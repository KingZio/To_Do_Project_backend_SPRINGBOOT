package org.hansei.toomanydo.repository;

import org.hansei.toomanydo.entity.Todo_entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo_entity, Long> {
    List<Todo_entity> findAllByUsername(String username);
}
