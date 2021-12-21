package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "candidates")
public class Kandidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    private String name;


   // @JsonManagedReference(value = "member")
    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parti_id", referencedColumnName = "id")
    private Parti parti;

    private String politicalView;

    private  int personalVotes;
/*
    @JsonIgnore
    @JsonBackReference(value = "personal-votes")
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private Set<Stemmeseddel> personalVotes;

 */


    public Kandidat() {
    }


    public Kandidat(int id, String name, Parti parti, String politicalView, int personalVotes) {
        this.id = id;
        this.name = name;
        this.parti = parti;
        this.politicalView = politicalView;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parti getParti() {
        return parti;
    }

    public void setParti(Parti parti) {
        this.parti = parti;
    }

    public String getPoliticalView() {
        return politicalView;
    }

    public void setPoliticalView(String politicalView) {
        this.politicalView = politicalView;
    }

    public int getPersonalVotes() {
        return personalVotes;
    }

    public int setPersonalVotes(){
        return personalVotes;
    }
}
