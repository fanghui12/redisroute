package com.chanjet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworldcontroller {
    @RequestMapping("/hello")
    public String index(){
        return "abc";
    }
}
