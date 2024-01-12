package com.DI.practica10;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumnos")
public class GetAlumnos {
    @GetMapping
    public String getAlumnos() {
        return "Alumnos";
    }
}
