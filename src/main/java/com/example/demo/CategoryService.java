package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public List<Category> listAll(String keyword) {
        if (keyword != null) {
            return repo.findAll(keyword);
        }
        return repo.findAll();
    }

    public void save(Category category) {
        repo.save(category);
    }

    public Category get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

