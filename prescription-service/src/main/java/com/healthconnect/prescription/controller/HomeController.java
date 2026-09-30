package com.healthconnect.prescription.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Prescription Service is up and running! Access API endpoints at /api/prescriptions";
    }
}
