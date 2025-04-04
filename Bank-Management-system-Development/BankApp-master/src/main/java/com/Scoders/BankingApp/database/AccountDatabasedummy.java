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
