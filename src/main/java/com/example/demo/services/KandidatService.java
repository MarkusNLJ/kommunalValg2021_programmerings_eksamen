package com.example.demo.services;

import com.example.demo.models.Kandidat;
import com.example.demo.models.Parti;
import com.example.demo.repository.KandidatRepository;
import com.example.demo.repository.PartiRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class KandidatService {

    private KandidatRepository kandidatRep;
    private PartiRepository partiRepository;

    public KandidatService(KandidatRepository kandidatRep, PartiRepository partiRepository){
        this.kandidatRep = kandidatRep;
        this.partiRepository = partiRepository;
    }


    public List<Kandidat> getAllPartiMembers(String parti){
        List<Kandidat> allPartiCandidates = new ArrayList<>();
        kandidatRep.findAll().forEach(allPartiCandidates::add);
        List <Kandidat> filteredCandidates = allPartiCandidates.stream().filter(kandidat -> kandidat.getParti().equals(parti)).collect(Collectors.toList());
        return filteredCandidates;
    }

    public List<Kandidat> getAllCandidates(){
        List<Kandidat> allCandidates = new ArrayList<>();
        kandidatRep.findAll().forEach(allCandidates::add);
        return allCandidates;
    }

    public void updateCandidat(Kandidat updatedCandidat) {
        Kandidat candidatToUpdate = kandidatRep.findById(updatedCandidat.getId()).get();
        candidatToUpdate = updatedCandidat;
        kandidatRep.save(candidatToUpdate);
    }

    public Optional<Kandidat> getCandidate(int id){
        return kandidatRep.findById(id);
    }

    public void deleteCandidate(int id){
        kandidatRep.deleteById(id);
    }


    public void addCandidate(Kandidat candidate){
        kandidatRep.save(candidate);
    }


}
