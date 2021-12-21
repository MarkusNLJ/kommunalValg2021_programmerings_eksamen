package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "citizens")
public class Borger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    private int CPR_number;

    private boolean hasVoted;
/*
    @JsonManagedReference
    @OneToOne(mappedBy = "borger", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Stemmeseddel stemmeseddel;

 */


    public Borger() {
    }

    public Borger(int id, int CPR_number, boolean hasVoted) {
        this.id = id;
        this.CPR_number = CPR_number;
        this.hasVoted = hasVoted;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCPR_number() {
        return CPR_number;
    }

    public void setCPR_number(int CPR_number) {
        this.CPR_number = CPR_number;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
/*
    public Stemmeseddel getStemmeseddel() {
        return stemmeseddel;
    }

    public void setStemmeseddel(Stemmeseddel stemmeseddel) {
        this.stemmeseddel = stemmeseddel;
    }

 */
}
