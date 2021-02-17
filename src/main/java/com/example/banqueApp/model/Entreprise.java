package com.example.banqueApp.model;

public class Entreprise extends Compte{
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Entreprise(int id, Long numeroCompte, double solde, String nom) {
        super(id, numeroCompte, solde);
        this.nom = nom;
    }
    public Entreprise(Long numeroCompte, double solde, String nom) {
        super(numeroCompte, solde);
        this.nom = nom;
    }
}
