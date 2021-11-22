package com.prueba.aplicacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JuegoController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/juego")
    public String jugar() {
        return "juego";
    }
    
    @GetMapping("/ranking")
    public String ranking() {
        return "ranking";
    }
}
