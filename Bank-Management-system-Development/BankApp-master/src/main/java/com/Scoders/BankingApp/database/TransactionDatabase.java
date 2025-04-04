package com.Scoders.BankingApp.database;

import com.Scoders.BankingApp.model.Account;
import com.Scoders.BankingApp.model.transaction;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransactionDatabase {

    private static final String DATABASE_URL = "jdbc:sqlite:bank.db"; // The SQLite database file


    public static void createTransactionTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Transactions ("
                + "transId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "amount DOUBLE, "
                + "dateTime TEXT, "
                + "accNo INTEGER, "
                + "transactionType TEXT, "
                + "FOREIGN KEY(accNo) REFERENCES Account(accNo))";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Transaction table created or already exists.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    public static void insertTransaction(Long accNo, Double amount, String transactionType) {
        String insertSQL = "INSERT INTO Transactions (amount, dateTime, accNo, transactionType) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setDouble(1, amount);
            pstmt.setString(2, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)); // current timestamp
            pstmt.setLong(3, accNo);
            pstmt.setString(4, transactionType);
            pstmt.executeUpdate();
            System.out.println("Transaction inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting transaction: " + e.getMessage());
        }
    }

    public static transaction getTransactionByTransId(Long transId) {
        String selectSQL = "SELECT * FROM Transactions WHERE transId = ?";
        transaction transaction = null;

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            pstmt.setLong(1, transId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Long id = rs.getLong("transId");
                Double amount = rs.getDouble("amount");
                String dateTime = rs.getString("dateTime");
                Long accNo = rs.getLong("accNo");
                String transactionType = rs.getString("transactionType");


