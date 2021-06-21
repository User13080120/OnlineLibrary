package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("Select p FROM Book p WHERE " + "CONCAT(p.id, p.name, p.autor, p.category, p.description)"
            + "LIKE %?1%")
    public List<Category> findAll(String keyword);
}
