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


