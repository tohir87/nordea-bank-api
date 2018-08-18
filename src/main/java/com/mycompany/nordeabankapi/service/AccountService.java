/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nordeabankapi.service;

import com.mycompany.nordeabankapi.model.Account;
import java.util.ArrayList;
import java.util.List;


public class AccountService {
    
    // Use ArrayList temporarily to mock the Database layer
    public static List<Account> list = new ArrayList<Account>();
    
    // define sortcode constant
    public static final String SORT_CODE = "543-876";

    // ADD ADDITIONAL FUNCTIONS
    // Return a list of all accounts open
    public List<Account> getAllAccounts() {
        Account a1 = new Account(1, "ABC-123", SORT_CODE, 1, 2341.50);
        Account a2 = new Account(2, "DEF-123", SORT_CODE, 2, 2341.50);
        Account a3 = new Account(3, "ABC-456", SORT_CODE, 1, 2341.50);
        Account a4 = new Account(4, "DEF-456", SORT_CODE, 2, 2341.50);

        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        return list;

    }

    // Return a specific account
    public Account getAccount(int id) {

        return list.get(id - 1);

    }
    
    public void addAccount(int customerId, int accountType, String AccountNumber){
        Account account = new Account(customerId, AccountNumber, SORT_CODE, accountType, 0);
        list.add(account);
        System.out.println("Account created successfully.");
    }
    
}
