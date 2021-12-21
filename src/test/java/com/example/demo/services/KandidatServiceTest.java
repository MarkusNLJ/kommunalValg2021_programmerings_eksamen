package com.example.demo.services;

import com.example.demo.models.Kandidat;
import com.example.demo.models.Parti;
import com.example.demo.repository.KandidatRepository;
import com.example.demo.repository.PartiRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

class KandidatServiceTest {

    @Mock
    KandidatRepository kandidatRepository;


    @InjectMocks
    KandidatService kandidatService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);

        Set<Kandidat> kandidats = new HashSet<>();
        Set<Kandidat> kandidats1 = new HashSet<>();
        Set<Kandidat> kandidats2 = new HashSet<>();

        Parti parti = new Parti(1, "Dansk folkeparti", "DF", "Mindre EU mere danmark", kandidats, 0);
        Parti parti1 = new Parti(2, "SF", "Socialistisk Folkeparti", "SF – et moderne grønt venstrefløjsparti baseret på lighed og frihed.", kandidats1, 0);
        Parti parti2 = new Parti(3, "Dansk folkeparti", "DF", "Mindre EU mere danmark", kandidats, 0);
        Parti parti3 = new Parti(4, "A", "Socialdemokratiet", "Den bedste opfindelse er danmark", kandidats2, 0);

        Kandidat kandidat = new Kandidat(1, "Tobias", parti, "En fortjent alderdom", 2);
        Kandidat kandidat1 = new Kandidat(2, "Kent", parti2, "Alt det gode", 10);
        Kandidat kandidat2 = new Kandidat(3, "Mille", parti2, "Mere omsorg", 1);
        Kandidat kandidat3 = new Kandidat(4, "Milas", parti3, "Mindre larm", 6);
        Kandidat kandidat4 = new Kandidat(5, "Markus", parti1, "bedre Hvidovre", 8);


        kandidats.add(kandidat);
        kandidats.add(kandidat1);
        kandidats.add(kandidat2);
        kandidats.add(kandidat3);
        kandidats.add(kandidat4);

        Mockito.when(kandidatRepository.findAll()).thenReturn(kandidats);
        Mockito.when(kandidatRepository.save(kandidat)).thenReturn(kandidat);
    }

       @Test
        void getAllCandidates () {

            //Arrange
            List<Kandidat> testList;

            //act
            testList = kandidatService.getAllCandidates();

            //assert
            assertEquals(5, testList.size());
            Mockito.verify(kandidatRepository, times(1)).findAll();
        }

    @Test
    void addCandidate(){
        //arrange
        Set<Kandidat> kandidats5 = new HashSet<>();
        Parti parti = new Parti(4, "A", "Socialdemokratiet", "Den bedste opfindelse er danmark", kandidats5, 0);
        Kandidat kandidat = new Kandidat(1, "Tobias", parti, "En fortjent alderdom", 0);
        kandidats5.add(kandidat);

        //act
        kandidatService.addCandidate(kandidat);

        //assert

        assertEquals(1, kandidat.getId());
        assertEquals("Tobias", kandidat.getName());
        assertEquals(4, kandidat.getParti().getPartiID());
        assertEquals("En fortjent alderdom", kandidat.getPoliticalView());
        assertEquals(0 , kandidat.getPersonalVotes());
        Mockito.verify(kandidatRepository, times(1)).save(kandidat);
    }

    }




