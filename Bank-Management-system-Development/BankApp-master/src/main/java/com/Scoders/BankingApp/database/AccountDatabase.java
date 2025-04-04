package com.Scoders.BankingApp.database;

import com.Scoders.BankingApp.model.Account;
import com.Scoders.BankingApp.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.Scoders.BankingApp.database.UserDatabase.getUserById;

public class AccountDatabase {

    private static final String DATABASE_URL = "jdbc:sqlite:bank.db"; // The SQLite database file


    public static void createAccountTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Account ("
                + "accNo TEXT PRIMARY KEY CHECK(length(accNo) = 8), "
                + "user_id INTEGER, "
                + "balance DOUBLE, "
                + "FOREIGN KEY(user_id) REFERENCES User(id))";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Account table created or already exists.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }


    public static void insertAccount(Long userId, Double balance) {
        String insertSQL = "INSERT INTO Account (accNo, user_id, balance) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {


            String accNo = generateAccountNumber();

            pstmt.setString(1, accNo);
            pstmt.setLong(2, userId);
            pstmt.setDouble(3, balance);
            pstmt.executeUpdate();

            System.out.println("Account inserted successfully with accNo: " + accNo);
        } catch (SQLException e) {
            System.out.println("Error inserting account: " + e.getMessage());
        }
    }