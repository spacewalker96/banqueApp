package com.example.banqueApp.database;

import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.util.Properties;

public class DbConfig {
    public static Connection  connect() {
        Connection con = null;
        try {
/*
            Class.forName("org.postgresql.Driver");
*/
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","admin");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return con;
    }
}
