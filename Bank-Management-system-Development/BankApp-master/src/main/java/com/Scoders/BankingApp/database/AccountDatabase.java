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

