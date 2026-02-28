package com.capgemini.library.service;

import com.capgemini.library.entity.Category;

import java.util.List;

public interface CategoryService {

    Category addCategory(Category category);

    Category getCategoryById(Long id);

    List<Category> getAllCategories();

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);
}