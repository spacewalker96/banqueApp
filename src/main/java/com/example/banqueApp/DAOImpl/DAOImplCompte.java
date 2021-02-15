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
    private static final String DELETE = "delete from banque.compte where compte_id = ?";
    private static final String UPDATE = "update banque.compte set compte_type = ?,compte_numero= ?, compte_solde =? where compte_id = ?";

    private static final String INSERT_ENTR = "INSERT INTO entr" + "  (entr_type, acount_numero, acount_solde, entr_nom) VALUES (?, ?, ?, ?)";
    private static final String INSERT_PERS = "INSERT INTO pers" + "  (pers_type, acount_numero, acount_solde, pers_nom, pers_prenom) VALUES (?, ?, ?, ?, ?)";
    private static String SELECTBOTH= "select pers_type,compte_numero,compte_solde from banque.compte where compte_type =?";



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
            preparedStatement.setString(1, entreprise.getCompteType());
            preparedStatement.setLong(2, entreprise.getNumeroCompte());
            preparedStatement.setDouble(3, entreprise.getSolde());
            preparedStatement.setString(4, entreprise.getNom());
            //  System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }


    public void insertComptePersone(Persone persone) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERS)) {
            preparedStatement.setString(1, persone.getCompteType());
            preparedStatement.setLong(2, persone.getNumeroCompte());
            preparedStatement.setDouble(3, persone.getSolde());
            preparedStatement.setString(4, persone.getNom());
            preparedStatement.setString(5, persone.getPrenom());
            //  System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }



    public void updateCompte(Compte compte) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(UPDATE);) {
            statement.setString(1, compte.getCompteType());
            statement.setLong(2, compte.getNumeroCompte());
            statement.setDouble(3, compte.getSolde());
            statement.setInt(4, compte.getId());
            statement.executeUpdate();
        }

    }

    public void deleteCompte(int id) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(DELETE);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }


    public Compte selectCompteType(String type) {
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
    }



    public List<Compte> allCompte() throws SQLException {
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
        }
    }
