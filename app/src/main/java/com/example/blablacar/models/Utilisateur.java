package com.example.blablacar.models;

public class Utilisateur {
    private String nom;
    private String mdp;
    private String email;

    public Utilisateur() {

    }

    public Utilisateur(String email, String mdp, String nom) {
        this.email = email;
        this.nom = nom;
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
