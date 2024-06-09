package com.example.blablacar.models;

public class Voiture {
    private String marque;
    private String modele;
    private String immatriculation;
    public Voiture() {
    }

    public Voiture(String marque, String modele, String immatriculation) {
        this.marque = marque;
        this.modele = modele;
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
}
