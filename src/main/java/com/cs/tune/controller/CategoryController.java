package com.cs.tune.controller;

import com.cs.tune.entity.Category;
import com.cs.tune.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @CrossOrigin
    @GetMapping("/api/categories")
    public List<Category> list() throws Exception {
        return categoryService.list();
    }

    @CrossOrigin
    @PostMapping("/api/categories")
    public Category addOrUpdate(@RequestBody Category category) throws Exception {
        categoryService.addOrUpdate(category);
        return category;
    }
}
