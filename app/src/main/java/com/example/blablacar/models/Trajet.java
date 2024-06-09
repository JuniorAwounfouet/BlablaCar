package com.example.blablacar.models;

import java.util.List;

public class Trajet {
    private String depart;
    private String arrivee;
    private float prix;
    private String hDepart;
    private String hArrivee;
    private Conducteur conducteur;
    private List<Passager> passagers;

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrivee() {
        return arrivee;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String gethDepart() {
        return hDepart;
    }

    public void sethDepart(String hDepart) {
        this.hDepart = hDepart;
    }

    public String gethArrivee() {
        return hArrivee;
    }

    public void sethArrivee(String hArrivee) {
        this.hArrivee = hArrivee;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public List<Passager> getPassagers() {
        return passagers;
    }

    public void setPassagers(List<Passager> passagers) {
        this.passagers = passagers;
    }

    public Trajet(String depart, String arrivee, float prix) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.prix = prix;
    }
}
