package com.cs.tune.service;

import com.cs.tune.dao.SongDao;
import com.cs.tune.entity.Album;
import com.cs.tune.entity.Category;
import com.cs.tune.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    SongDao songDao;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AlbumService albumService;

    public List<Song> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return songDao.findAll(sort);
    }

    public void addOrUpdate(Song song) {
        // save() 方法当主键存在时更新数据，当主键不存在时插入数据
        songDao.save(song);
    }

    public void deleteById(int id) {
        songDao.deleteById(id);
    }

    public List<Song> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return songDao.findAllByCategory(category);
    }

    public List<Song> listByAlbum(int aid) {
        Album album = albumService.get(aid);
        return songDao.findAllByAlbums(album);
    }

    public List<Song> Search(String keywords) {
        return songDao.findAllBySongLikeOrSingerLikeOrAlbumLike('%' + keywords + '%', '%' + keywords + '%', '%' + keywords + '%');
    }
}
