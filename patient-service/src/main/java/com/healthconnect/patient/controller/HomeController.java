package com.healthconnect.patient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Patient Service is up and running! Access API endpoints at /api/patients";
    }
}
