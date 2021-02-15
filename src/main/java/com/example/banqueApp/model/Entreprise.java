package com.example.banqueApp.model;

public class Entreprise {
    private int id;
    private Long numeroCompte;
    private double solde;
    private String compteType;
    private String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(Long numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getCompteType() {
        return compteType;
    }

    public void setCompteType(String compteType) {
        this.compteType = compteType;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Entreprise(int id, Long numeroCompte, double solde, String compteType, String nom) {
        this.id = id;
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.compteType = compteType;
        this.nom = nom;
    }

    public Entreprise(Long numeroCompte, double solde, String compteType, String nom) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.compteType = compteType;
        this.nom = nom;
    }
}
