package edu.miu.cs425.demowebapps.eRegistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping(value = {"/", "/elibrary","/elibrary/home"})
    public String displayHomePage(){
        return "home/index";
    }
}
