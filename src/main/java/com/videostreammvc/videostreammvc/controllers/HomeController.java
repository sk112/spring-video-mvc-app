package com.videostreammvc.videostreammvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String home(Model model){
        model.addAttribute("name", "Sample1.mp4");

        return "index";
    }

}