package com.Scoders.BankingApp.database;

import com.Scoders.BankingApp.model.Account;
import com.Scoders.BankingApp.model.User;

import java.sql.*;

import static com.Scoders.BankingApp.database.UserDatabase.getUserById;

public class AccountDatabasedummy {

    private static final String DATABASE_URL = "jdbc:sqlite:bank.db"; // The SQLite database file

    // Method to create the Account table
    public static void createAccountTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Account ("
                + "accNo INTEGER PRIMARY KEY AUTOINCREMENT, "
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
        String insertSQL = "INSERT INTO Account (user_id, balance) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setLong(1, userId);
            pstmt.setDouble(2, balance);
            pstmt.executeUpdate();
            System.out.println("Account inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting account: " + e.getMessage());
        }
    }

    public static Account getAccountByAccNo(Long accNo) {
        String selectSQL = "SELECT * FROM Account WHERE accNo = ?";
        Account account = null;

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            pstmt.setLong(1, accNo);
            ResultSet rs = pstmt.executeQuery();
