package com.codegym.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDTO {
    private long id;

    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "[a-zA-Z0-9 ]*",message = "Không được chứa các kí tự đặc biệt")
    @Size(max = 800,message = "Không vượt quá 800 ký tự")
    private String nameSong;

    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "[a-zA-Z0-9 ]*",message = "Không được chứa các kí tự đặc biệt")
    @Size(max = 300,message = "Không vượt quá 300 ký tự")
    private String nameSinger;

    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "[a-zA-Z0-9, ]*",message = "Không được chứa các kí tự đặc biệt, ngoại trừ ','")
    @Size(max = 1000,message = "Không vượt quá 1000 ký tự")
    private String songType;

    public SongDTO() {
    }

    public SongDTO(long id, @NotBlank(message = "không được để trống") @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "Không được chứa các kí tự đặc biệt") @Size(max = 800, message = "Không vượt quá 800 ký tự") String nameSong, @NotBlank(message = "không được để trống") @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "Không được chứa các kí tự đặc biệt") @Size(max = 300, message = "Không vượt quá 300 ký tự") String nameSinger, @NotBlank(message = "không được để trống") @Pattern(regexp = "[a-zA-Z0-9, ]*", message = "Không được chứa các kí tự đặc biệt, ngoại trừ ','") @Size(max = 1000, message = "Không vượt quá 1000 ký tự") String songType) {
        this.id = id;
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.songType = songType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }
}
