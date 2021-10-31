package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.model.SongForm;
import com.codegym.service.ISongService;
import com.codegym.service.SongServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    private final ISongService songService = new SongServiceImpl();

    @GetMapping("")
    public String index(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "/index";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }
    @Value("${file-upload}")
    private String fileUpload;
    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute SongForm songForm) {
        MultipartFile multipartFile = songForm.getSong();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getSongName(),songForm.getSingerName(),
                songForm.getSongType(), fileName);
        System.out.println(song.getSong());
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songForm", songForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public String editSong(@PathVariable int id , Model model){
        Song song = songService.findById(id);
        SongForm songForm = new SongForm(song.getId(),song.getSongName(),song.getSingerName(),song.getSongType(),null);
      model.addAttribute("songForm",songForm);
      return "/edit";
    }
    @PostMapping("/edit")
    public ModelAndView updateSong(@ModelAttribute SongForm songForm) {
        MultipartFile multipartFile = songForm.getSong();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getSongName(),songForm.getSingerName(),
                songForm.getSongType(), fileName);
        System.out.println(song.getSong());
        songService.update(song);
        List<Song> songList = songService.findAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("songForm", songForm);
        modelAndView.addObject("message", "Created new product successfully !");
        modelAndView.addObject("songList", songList);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable int id,Model model) {
        songService.remove(id);
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "/index";
    }

}
