package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.model.SongDTO;
import com.codegym.service.SongServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    SongServiceImpl songService;
    @GetMapping("")
    public String showList(Model model){
        List<Song> songList = songService.findAll();
        model.addAttribute("songList",songList);
        return "/list";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songDTO", new SongDTO());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView saveSong(@ModelAttribute @Validated SongDTO songDTO,
                                 BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("/create");

            return modelAndView;
        }else {
            Song song =new Song();
            BeanUtils.copyProperties(songDTO,song);
            songService.save(song);
            ModelAndView modelAndView = new ModelAndView("/create");
            return modelAndView;
        }
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable long id) {
        Song song = songService.findById(id);
        SongDTO songDTO = new SongDTO();
        BeanUtils.copyProperties(song,songDTO);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("songDTO",songDTO    );
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView saveEditSong(@ModelAttribute @Validated SongDTO songDTO,
                                 BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("/edit");

            return modelAndView;
        }else {
            Song song =new Song();
            BeanUtils.copyProperties(songDTO,song);
            songService.save(song);
            List<Song> songList = songService.findAll();

            ModelAndView modelAndView = new ModelAndView("/list");
            modelAndView.addObject("songList",songList);
            return modelAndView;
        }
    }
}
