package com.Scoders.BankingApp.database;

import com.Scoders.BankingApp.model.User;

import java.sql.*;

public class UserDatabase {

    private static final String DATABASE_URL = "jdbc:sqlite:bank.db";

    public static void createUserTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS User ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "username TEXT, "
                + "surname TEXT, "
                + "password TEXT)";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("User table created or already exists.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

