package com.cs.tune.dao;

import com.cs.tune.entity.Album;
import com.cs.tune.entity.Category;
import com.cs.tune.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongDao extends JpaRepository<Song,Integer> {
    List<Song> findAllByCategory(Category category);
    List<Song> findAllByAlbums(Album album);
    List<Song> findAllBySongLikeOrSingerLikeOrAlbumLike(String keyword1, String keyword2, String keyword3);
}
