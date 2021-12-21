package com.example.demo.controllers;

import com.example.demo.models.Parti;
import com.example.demo.services.PartiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Partier")
public class PartiController {

    PartiService partiService;

    public PartiController(PartiService partiService){
        this.partiService = partiService;
    }

    @GetMapping
    public ResponseEntity<List<Parti>> getAllParties(){
        List<Parti> allParties = partiService.getAllParties();
        return ResponseEntity.status(HttpStatus.OK).body(allParties);
    }
}
