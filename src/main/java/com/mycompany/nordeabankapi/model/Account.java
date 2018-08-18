/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nordeabankapi.model;

import static com.mycompany.nordeabankapi.model.DAO.DB_URL;
import static com.mycompany.nordeabankapi.model.DAO.DRIVER;
import static com.mycompany.nordeabankapi.model.DAO.PASS;
import static com.mycompany.nordeabankapi.model.DAO.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account {
    
    // class variables
    private int id;
    private int customerId;
    private String accountNo;
    private String sortCode;
    private int accountType;    // Savings/current
    private double currentBalance;

    
    // Constructors
    public Account() {
    }

    public Account(int customerId, String accountNo, String sortCode, int accountType, double currentBalance) {
        this.customerId = customerId;
        this.accountNo = accountNo;
        this.sortCode = sortCode;
        this.accountType = accountType;
        this.currentBalance = currentBalance;
        
        // save account details into database
        String sql = "INSERT INTO accounts(customer_id,account_number,sort_code, account_type, current_balance) "
                   + "VALUES(?,?,?,?,?)";
        
        ResultSet rs = null;

        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            // set parameters for statement
            pstmt.setInt(1, this.customerId);
            pstmt.setString(2, this.accountNo);
            pstmt.setString(3, this.sortCode);
            pstmt.setInt(4, this.accountType);
            pstmt.setDouble(5, this.currentBalance);
            
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {
                // get candidate id
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
//                    customerId = rs.getInt(1);
                this.id = rs.getInt(1);
 
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            // TODO: handle exception
            System.out.println(ex.getMessage());
        }
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getSortCode() {
        return sortCode;
    }

    public int getAccountType() {
        return accountType;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString() {
        return "Account{" + "customerId=" + customerId + ", accountNo=" + accountNo + ", sortCode=" + sortCode + ", accountType=" + accountType + ", currentBalance=" + currentBalance + '}';
    }

    
    
}
