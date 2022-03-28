package com.cs.tune.controller;

import com.cs.tune.entity.Album;
import com.cs.tune.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AlbumController {
    @Autowired
    AlbumService albumService;

    @CrossOrigin
    @GetMapping("/api/albums")
    public List<Album> list() throws Exception {
        return albumService.list();
    }
}
