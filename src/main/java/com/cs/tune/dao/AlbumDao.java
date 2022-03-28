package com.cs.tune.dao;

import com.cs.tune.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumDao extends JpaRepository<Album, Integer> {
}
