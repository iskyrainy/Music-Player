package com.cs.tune.controller;

import com.cs.tune.entity.Song;
import com.cs.tune.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TuneController {
    @Autowired
    SongService songService;

    @CrossOrigin
    @GetMapping("/api/songs")
    public List<Song> list() throws Exception {
        return songService.list();
    }

    @CrossOrigin
    @PostMapping("/api/songs")
    public Song addOrUpdate(@RequestBody Song song) throws Exception {
        songService.addOrUpdate(song);
        return song;
    }

    @CrossOrigin
    @PostMapping("/api/delete")
    public void delete(@RequestBody Song song) throws Exception {
        songService.deleteById(song.getId());
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/songs")
    public List<Song> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return songService.listByCategory(cid);
        } else {
            return list();
        }
    }

    @CrossOrigin
    @GetMapping("/api/albums/{aid}/songs")
    public List<Song> listByAlbum(@PathVariable("aid") int aid) throws Exception {
        if (0 != aid) {
            return songService.listByAlbum(aid);
        } else {
            return list();
        }
    }

    @CrossOrigin
    @GetMapping("/api/searches")
    public List<Song> searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return songService.list();
        } else {
            return songService.Search(keywords);
        }
    }
}
