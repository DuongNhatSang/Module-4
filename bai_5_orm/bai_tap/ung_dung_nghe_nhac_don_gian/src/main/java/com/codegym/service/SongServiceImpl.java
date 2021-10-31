package com.codegym.service;

import com.codegym.model.Song;
import com.codegym.repository.SongRepositoryImpl;

import java.util.List;

public class SongServiceImpl implements ISongService {
    private SongRepositoryImpl songRepository = new SongRepositoryImpl();
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public void update(Song song) {
        songRepository.update(song);
    }

    @Override
    public void remove(int id) {
        songRepository.remove(id);
    }
}
