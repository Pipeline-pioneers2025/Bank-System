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

