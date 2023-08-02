package com.springbootlearning.learningspringboot3.ch2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final VideoService videoService;

    public HomeController(VideoService videoService) {
        this.videoService = videoService;
    }
    
    @GetMapping("/")
        public String index(Model model) {
        model.addAttribute("videos", videoService.getVideos());
        
        return "index";
    
    }

}
