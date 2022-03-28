package com.cs.tune.service;

import com.cs.tune.dao.AlbumDao;
import com.cs.tune.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    AlbumDao albumDao;

    public List<Album> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "aid");
        return albumDao.findAll(sort);
    }

    public Album get(int id) {
        return albumDao.findById(id).orElse(null);
    }
}
