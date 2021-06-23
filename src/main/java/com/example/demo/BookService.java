package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public List<Book> listAll(String keyword) {
        if (keyword != null) {
            return repo.findAll(keyword);
        }
        return repo.findAll();
    }

    public void save(Book book) {
        repo.save(book);
    }

    public Book get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}

