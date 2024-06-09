package com.example.blablacar;

public class Conducteur extends Utilisateur {
    private Voiture voiture;
    private String numeroPermis;

    public Conducteur() {
    }

    public Conducteur(String numeroPermis, Voiture voiture) {
        this.voiture = voiture;
        this.numeroPermis = numeroPermis;
    }

    public String getNumeroPermis() {
        return numeroPermis;
    }

    public void setNumeroPermis(String numeroPermis) {
        this.numeroPermis = numeroPermis;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }
}
