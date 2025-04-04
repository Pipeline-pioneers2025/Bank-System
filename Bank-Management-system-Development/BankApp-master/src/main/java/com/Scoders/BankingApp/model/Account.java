package com.Scoders.BankingApp.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class    Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accNo;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private Double balance;

    public Account() {
    }

    public Account(Long accNo, User user, Double balance) {
        this.accNo = accNo;
        this.user = user;
        this.balance = balance;
    }