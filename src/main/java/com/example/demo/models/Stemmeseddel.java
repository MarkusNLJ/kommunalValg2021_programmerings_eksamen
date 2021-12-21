package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ballot")
public class Stemmeseddel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @JsonManagedReference(value = "personal-votes")
    @ManyToOne
    @JoinColumn(name = "chosen_candidate")
    private Kandidat candidate;

    @JsonBackReference(value = "parti-votes")
    @ManyToOne
    @JoinColumn(name = "chosen_parti")
    private Parti parti;
/*
    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "borger_id")
    private Borger borger;

 */


    public Stemmeseddel() {
    }

    public Stemmeseddel(int id, Kandidat candidate, Parti parti) {
        this.id = id;
        this.candidate = candidate;
        this.parti = parti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kandidat getCandidate() {
        return candidate;
    }

    public void setCandidate(Kandidat candidate) {
        this.candidate = candidate;
    }

    public Parti getParti() {
        return parti;
    }

    public void setParti(Parti parti) {
        this.parti = parti;
    }
/*
    public Borger getBorger() {
        return borger;
    }

    public void setBorger(Borger borger) {
        this.borger = borger;
    }

 */
}
