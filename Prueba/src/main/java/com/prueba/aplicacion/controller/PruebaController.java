package com.prueba.aplicacion.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class PruebaController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/dates")
    public String dates(Model model) {

        model.addAttribute("tstamp", LocalDateTime.now());
        return "dates";
    }
    
    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
