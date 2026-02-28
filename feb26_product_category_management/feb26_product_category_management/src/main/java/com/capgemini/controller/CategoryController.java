package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.capgemini.entity.Category;
import com.capgemini.repository.CategoryRepository;

@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryjpa;

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category c) {
        return categoryjpa.save(c);
    }

    @GetMapping("/categories/{page}/{size}")
    public List<Category> getCategory(@PathVariable int page,
                                      @PathVariable int size) {

        Page<Category> p = categoryjpa.findAll(
                PageRequest.of(page, size, Sort.by("id").descending())
        );

        return p.getContent();
    }
}