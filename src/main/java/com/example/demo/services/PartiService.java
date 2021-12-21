package com.example.demo.services;

import com.example.demo.models.Parti;
import com.example.demo.repository.PartiRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartiService {

    private PartiRepository partiRep;

    public PartiService(PartiRepository partiRep){
        this.partiRep = partiRep;
    }

    public Parti getSpecificParti(int id){
        return partiRep.findById(id).get();
    }


    public List<Parti> getAllParties(){
        List<Parti> allParties = new ArrayList<>();
        partiRep.findAll().forEach(allParties::add);
        return allParties.stream().sorted(Comparator.comparing(Parti::getLetter)).collect(Collectors.toList());
    }
}
