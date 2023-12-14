package com.bhavik.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${datasource.psd}")
    private String psd;


    @GetMapping("home")
    public String getHomePage(){
        return "Home";
    }

    @GetMapping("home1")
    public String getHomePage1(){
        return "Testing DB PSD: " + psd;
    }
}
