/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nordeabankapi.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author
 */
@XmlRootElement
public class Transaction implements DAO {

    /**
     * Class variables
     */
    private int id;
    private int transactionType; // 1 - Credit, 2- Debit
    private double amount;
    private String description;
    private double balance;
    private Date transactionDate;
    private int accountId;

    /**
     * Constructor
     * @param id
     * @param type
     * @param description
     * @param amount
     */
    public Transaction(int accountId , int type, String description, double amount) {
        this.accountId = accountId;
        this.transactionType = type;
        this.description = description;
//        this.newBalance = newBalance;
        this.transactionDate = new Date();
    }

    
    
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int transactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setDateCreated(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
