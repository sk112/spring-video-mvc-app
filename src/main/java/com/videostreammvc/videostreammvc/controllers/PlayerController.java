package com.videostreammvc.videostreammvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PlayerController {

    @GetMapping("/video/{name}/player")
    public String player(@PathVariable String name, Model model){
        
        model.addAttribute("videoname", name);
        return "player";
    }
}