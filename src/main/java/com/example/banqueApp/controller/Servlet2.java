package com.example.banqueApp.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.example.banqueApp.DAO.DAOCompte;
import com.example.banqueApp.DAOImpl.DAOImplCompte;
import com.example.banqueApp.model.Compte;
import com.example.banqueApp.model.Entreprise;
import com.example.banqueApp.model.Persone;

import static com.example.banqueApp.database.DbConfig.connect;

// Servlet Name 

@WebServlet("/")

public class Servlet2 extends HttpServlet {
    private DAOCompte daoCompte;

    public Servlet2() throws SQLException {
    }

    public void init() {
        daoCompte = new DAOImplCompte();
    }

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {


        //response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter out = response.getWriter();
        out.print("<br>");
        out.print("<h1>Liste des Entreprise</h1>");

        out.println("<table border='1'><tr><th>Id</th><th>Numero</th><th>Solde</th><th>Nom</th><th>Delete</th>");


        try {
            Connection con = connect();;
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery("select * from entr");
            while(rs.next()) {
                int id1  = rs.getInt(1);



                out.print("<tr><td>");
                out.println(rs.getInt(1));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getLong(2));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getDouble(3));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getString(6));
                out.print("</td>");
                out.print("<td>");
                out.print("<a href=delete?id=");
                out.println(id1);
                out.print(">");
                out.println("Delete");
                out.println("</a>");
                out.print("</td>");

                out.print("</tr>");
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }
        out.print("</table>");

        out.print("<br>");
        out.print("<h1>Liste des Personnes</h1>");


        out.println("<table border='1'><tr><th>Id</th><th>Numero</th><th>Solde</th><th>Nom</th><th>Prenom</th><th>Delete</th>");


        try {
            Connection con = connect();;
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery("select * from pers");
            while(rs.next()) {
                int id1  = rs.getInt(1);


                out.print("<tr><td>");
                out.println(rs.getInt(1));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getLong(2));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getDouble(3));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getString(6));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getString(7
                ));
                out.print("</td>");
                out.print("<td>");
                out.print("<a href=delete?id=");
                out.println(id1);
                out.print(">");
                out.println("Delete");
                out.println("</a>");
                out.print("</td>");

                out.print("</tr>");
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }
        out.print("</table>");



        String action = request.getServletPath();

        switch (action) {
            case "/":
                try {
                    compteList(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "/insertEntr":
                insertEntreprise(request, response);
                break;
            case "/insertPers":
                insertPersone(request, response);
                break;
            case "/delete":
                delete(request, response);
                break;
          /*  case "/edit":
                showEdit(request, response);
                break;
*/
            case "/update":
                update(request, response);
                break;
            default:
               /* try {
                    compteList(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }*/
                break;
        }


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

  /*  private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        Compte existingCompte = daoCompte.selectCompteType(type);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        request.setAttribute("compte", existingCompte);
        dispatcher.forward(request, response);

    }*/

    private void compteList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Compte> compteList = daoCompte.allCompte();
        request.setAttribute("comptes", compteList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }


    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        double solde = Double.parseDouble(request.getParameter("solde"));
        long numero = Long.parseLong(request.getParameter("numero"));

        int id = Integer.parseInt(request.getParameter("id"));
        Compte compte1 = new Compte(id, numero, solde, type);
        try {
            daoCompte.updateCompte(compte1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");


    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));


        try {
            daoCompte.deleteCompte(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");

    }




    /*private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        double solde = Double.parseDouble(request.getParameter("solde"));
        long numero = Long.parseLong(request.getParameter("numero"));
        Compte compte = new Compte(numero, solde, type);
        try {
            daoCompte.insertCompte(compte);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }*/

    private void insertEntreprise(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        double solde = Double.parseDouble(request.getParameter("solde"));
        long numero = Long.parseLong(request.getParameter("numero"));
        String nom = request.getParameter("nom");
        Entreprise entreprise = new Entreprise(numero, solde, type,nom);
        try {
            daoCompte.insertCompteEntreprise(entreprise);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }

    private void insertPersone(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        double solde = Double.parseDouble(request.getParameter("solde"));
        long numero = Long.parseLong(request.getParameter("numero"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        Persone persone = new Persone(numero, solde, type,nom,prenom);
        try {
            daoCompte.insertComptePersone(persone);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }


}


