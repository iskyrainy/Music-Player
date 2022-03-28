package com.cs.tune.service;

import com.cs.tune.dao.CategoryDao;
import com.cs.tune.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "cid");
        return categoryDao.findAll(sort);
    }

    public Category get(int id) {
        return categoryDao.findById(id).orElse(null);
    }

    public void addOrUpdate(Category category) {
        // save() 方法当主键存在时更新数据，当主键不存在时插入数据
        categoryDao.save(category);
    }
}
