package com.example.banqueApp.model;

public class Persone extends Entreprise{
    private String prenom;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Persone(Long numeroCompte, double solde, String nom, String prenom) {
        super(numeroCompte, solde, nom);
        this.prenom = prenom;
    }

    public Persone(int id, Long numeroCompte, double solde, String nom, String prenom) {
        super(id, numeroCompte, solde, nom);
        this.prenom = prenom;
    }
}
