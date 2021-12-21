package com.example.demo.controllers;

import com.example.demo.models.Kandidat;
import com.example.demo.models.Parti;
import com.example.demo.repository.PartiRepository;
import com.example.demo.services.KandidatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/Kandidater")
public class KandidatController {

    private KandidatService kandidatService;
    private PartiRepository partiRepository;

    public KandidatController(KandidatService kandidatService){
        this.kandidatService = kandidatService;
    }

    @GetMapping
    public ResponseEntity<List<Kandidat>>getAllCandidates(){
        List<Kandidat> allCandidates = kandidatService.getAllCandidates();
        return ResponseEntity.status(HttpStatus.OK).body(allCandidates);
    }

    @GetMapping("/{parti}")
    public ResponseEntity<List<Kandidat>>getAllPartiCandidates(@PathVariable String parti){
        List<Kandidat> allPartiCandidates = kandidatService.getAllPartiMembers(parti);
        return ResponseEntity.status(HttpStatus.OK).body(allPartiCandidates);
    }

    @PostMapping("/{parti}")
    public ResponseEntity<Kandidat> createCandidate(@RequestBody Kandidat kandidat, @PathVariable ("parti") int parti){
        Parti party = partiRepository.findById(parti).get();
        kandidat.setParti(party);
        kandidatService.addCandidate(kandidat);
        return new ResponseEntity<>(kandidat, HttpStatus.CREATED);
        //return ResponseEntity.status(HttpStatus.CREATED).body(kandidat);
    }

    @PutMapping
    public ResponseEntity<Kandidat> updateCandidate(@RequestBody Kandidat kandidat){
        kandidatService.updateCandidat(kandidat);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCandidate(@PathVariable int id){
        Optional<Kandidat> candidate = kandidatService.getCandidate(id);
        if (candidate.isPresent()){
            kandidatService.deleteCandidate(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}



