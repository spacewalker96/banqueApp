package com.example.banqueApp.DAO;

import com.example.banqueApp.model.Compte;
import com.example.banqueApp.model.Entreprise;
import com.example.banqueApp.model.Persone;

import java.sql.SQLException;
import java.util.List;

public interface DAOCompte {

   // public void insertCompte(Compte compte) throws SQLException;
    public void updateCompte(Compte compte) throws SQLException;
    public void deleteCompte(int id) throws SQLException;
    public Compte selectCompteType(String type);
    public List<Compte> allCompte() throws SQLException;
    public void insertComptePersone(Persone persone) throws SQLException;
    public void insertCompteEntreprise(Entreprise entreprise) throws SQLException;

}
