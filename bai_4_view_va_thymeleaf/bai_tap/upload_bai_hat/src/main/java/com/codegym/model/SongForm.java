package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private int id;
    private String songName;
    private String singerName;
    private String songType;
    private MultipartFile song;

    public SongForm() {
    }

    public SongForm(int id, String songName, String singerName, String songType, MultipartFile song) {
        this.id = id;
        this.songName = songName;
        this.singerName = singerName;
        this.songType = songType;
        this.song = song;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public MultipartFile getSong() {
        return song;
    }

    public void setSong(MultipartFile song) {
        this.song = song;
    }
}
