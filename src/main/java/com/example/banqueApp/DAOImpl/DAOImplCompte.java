package com.example.banqueApp.DAOImpl;

import com.example.banqueApp.DAO.DAOCompte;
import com.example.banqueApp.model.Compte;
import com.example.banqueApp.model.Entreprise;
import com.example.banqueApp.model.Persone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.banqueApp.database.DbConfig.connect;

public class DAOImplCompte implements DAOCompte {

    private static final String INSERT = "INSERT INTO banque.compte" + "  (compte_type, compte_numero, compte_solde) VALUES (?, ?, ?)";
    private static String SELECT= "select compte_type,compte_numero,compte_solde from banque.compte where compte_type =?";
   private static final String SELECT_ALL = "select * from banque.compte";
   // private static final String DELETE = "delete from banque.compte where compte_id = ?";
   // private static final String UPDATE = "update banque.compte set compte_type = ?,compte_numero= ?, compte_solde =? where compte_id = ?";

    private static final String INSERT_ENTR = "INSERT INTO entr" + "  (acount_numero, acount_solde, entr_nom) VALUES (?, ?, ?)";
    private static final String INSERT_PERS = "INSERT INTO pers" + "  (acount_numero, acount_solde, pers_nom, pers_prenom) VALUES (?, ?, ?, ?)";
    private static String SELECTBOTH= "select pers_type,compte_numero,compte_solde from banque.compte where compte_type =?";
    private static final String DELETEPERS = "delete from pers where acount_id = ?";
    private static final String DELETEENTR = "delete from entr where acount_id = ?";
    private static final String UPDATEPERS = "update pers set acount_numero = ?,acount_solde= ?, pers_nom =? , pers_prenom =? where acount_id = ?";
    private static final String UPDATEENTR = "update entr set acount_numero = ?,acount_solde= ?, entr_nom =? where acount_id = ?";






    /*public void insertCompte(Compte compte) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, compte.getCompteType());
            preparedStatement.setLong(2, compte.getNumeroCompte());
            preparedStatement.setDouble(3, compte.getSolde());
            //  System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }*/

    public void insertCompteEntreprise(Entreprise entreprise) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ENTR)) {
           // preparedStatement.setString(1, entreprise.getCompteType());
            preparedStatement.setLong(1, entreprise.getNumeroCompte());
            preparedStatement.setDouble(2, entreprise.getSolde());
            preparedStatement.setString(3, entreprise.getNom());
            //  System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }


    public void insertComptePersone(Persone persone) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERS)) {
            preparedStatement.setLong(1, persone.getNumeroCompte());
            preparedStatement.setDouble(2, persone.getSolde());
            preparedStatement.setString(3, persone.getNom());
            preparedStatement.setString(4, persone.getPrenom());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }



    public void updatePersone(Persone persone) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(UPDATEPERS);) {
            // statement.setString(1, compte.getCompteType());
            statement.setLong(1, persone.getNumeroCompte());
            statement.setDouble(2, persone.getSolde());
            statement.setString(3, persone.getNom());
            statement.setString(4, persone.getPrenom());
            statement.setInt(5, persone.getId());

            statement.executeUpdate();
        }

    }
    public void updateEntreprise(Entreprise entreprise) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(UPDATEENTR);) {
            // statement.setString(1, compte.getCompteType());
            statement.setLong(1, entreprise.getNumeroCompte());
            statement.setDouble(2, entreprise.getSolde());
            statement.setString(3, entreprise.getNom());
            statement.setInt(4, entreprise.getId());
            statement.executeUpdate();
        }

    }

    public void deletePersone(int id) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(DELETEPERS);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
    public void deleteEntreprise(int id) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(DELETEENTR);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }




   /* public Compte selectCompteType(String type) {
        Compte compte = null;
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
            preparedStatement.setString(1, type);
            //System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String compte_type = rs.getString("compte_type");
                long compte_numero = rs.getLong("compte_numero");
                double compte_solde = rs.getDouble("compte_solde");
                compte = new Compte(compte_numero , compte_solde, compte_type);
            }
        } catch (SQLException e) {

        }
        return compte;
    }*/



    /*public List<Compte> allCompte() throws SQLException {
        List<Compte> comptes = new ArrayList<>();
        Connection connection = connect();;
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                while (rs.next()) {
                    int compte_id = rs.getInt("compte_id");
                    String compte_type = rs.getString("compte_type");
                    long compte_numero = rs.getLong("compte_numero");
                    double compte_solde = rs.getDouble("compte_solde");
                    comptes.add(new Compte(compte_id, compte_numero, compte_solde, compte_type));

                }
            }
            return comptes;
        }
        }*/
    }
