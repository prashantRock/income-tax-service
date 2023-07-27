package com.incometax.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/provider")
public class TestController {


    @GetMapping("/secure/home.jsp")
    public ResponseEntity<String> calculateIncomeTaxToBePaid() {
        try {

            return ResponseEntity.status(HttpStatus.OK).body("Hello");
        } catch (Exception e) {
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
