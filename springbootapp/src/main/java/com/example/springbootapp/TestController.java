package com.example.springbootapp;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tests")
class TestController{
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/healthCheck")
    public void healthCheck(){
        System.out.println("Health Check Successfull data recieved");
    }
}
