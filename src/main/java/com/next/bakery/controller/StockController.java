package com.next.bakery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/stocks")
public class StockController {

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok("Hello world!");
    }
}
