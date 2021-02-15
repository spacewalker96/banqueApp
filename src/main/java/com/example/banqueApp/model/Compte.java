package com.example.banqueApp.model;

public class Compte {
    private int id;
    private Long numeroCompte;
    private double solde;
    private String compteType;

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

    public Compte(Long numeroCompte, double solde, String compteType) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.compteType = compteType;
    }

    public Compte(int id, Long numeroCompte, double solde, String compteType) {
        this.id = id;
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.compteType = compteType;
    }
}
