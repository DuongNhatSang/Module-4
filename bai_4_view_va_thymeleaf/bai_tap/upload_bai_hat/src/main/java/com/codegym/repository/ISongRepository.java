package com.codegym.repository;

import com.codegym.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();

    void save(Song song);

    Song findById(int id);

    void update(int id, Song song);

    void remove(int id);
}
