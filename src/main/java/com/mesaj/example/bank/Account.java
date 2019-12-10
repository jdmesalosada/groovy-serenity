package com.mesaj.example.bank;

import java.util.Date;

public class Account {

    private String accountHolder;
    private double balance;
    private Date dateCreated;

    public Account(String accountHolder, double balance, Date dateCreated) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.dateCreated = dateCreated;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public boolean withdraw(final double withdrawalAmount) {
        if (withdrawalAmount < balance) {
            balance -= withdrawalAmount;
            return true;
        }
        return false;
    }

    public void lodge(final double lodgementAmount) {
        balance += lodgementAmount;
    }

    public void applyInterest(final double interestRate) {
        balance += (balance * interestRate);
    }
}
