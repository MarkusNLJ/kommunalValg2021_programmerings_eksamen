package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "parties")
public class Parti {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int partiID;

    private String name;


    private String letter;

    private String slogan;

    @JsonBackReference(value = "member")
    @OneToMany(mappedBy = "parti", cascade = CascadeType.ALL)
    private Set<Kandidat> listOfPartiCandidates;

    private int totalNumberOfVotes;

/*
    @JsonBackReference(value = "parti-votes")
    @OneToMany(mappedBy = "parti", cascade = CascadeType.ALL)
    private Set<Stemmeseddel> numberOfVotes;

 */

    public Parti() {
    }

    public Parti(int partiID, String name, String letter, String slogan, Set<Kandidat> listOfPartiCandidates, int totalNumberOfVotes) {
        this.partiID = partiID;
        this.name = name;
        this.letter = letter;
        this.slogan = slogan;
        this.listOfPartiCandidates = listOfPartiCandidates;
        this.totalNumberOfVotes = totalNumberOfVotes;
    }

    public int getPartiID() {
        return partiID;
    }

    public void setPartiID(int partiID) {
        this.partiID = partiID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public Set<Kandidat> getListOfPartiCandidates() {
        return listOfPartiCandidates;
    }

    public void setListOfPartiCandidates(Set<Kandidat> listOfPartiCandidates) {
        this.listOfPartiCandidates = listOfPartiCandidates;
    }

    public int getTotalNUmberOfVotes() {
        return totalNumberOfVotes;
    }

    public void setTotalNUmberOfVotes(int totalNUmberOfVotes) {
        this.totalNumberOfVotes = totalNUmberOfVotes;
    }
}
