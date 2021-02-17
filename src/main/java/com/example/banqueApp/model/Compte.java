package com.example.banqueApp.model;

public class Compte {
    private int id;
    private Long numeroCompte;
    private double solde;
    //private String compteType;

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




    public Compte(Long numeroCompte, double solde) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;

    }

    public Compte(int id, Long numeroCompte, double solde) {
        this.id = id;
        this.numeroCompte = numeroCompte;
        this.solde = solde;

    }
}
