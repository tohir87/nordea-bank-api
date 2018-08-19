/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nordeabankapi.service;

import com.mycompany.nordeabankapi.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author 
 */
public class CustomerService {
    
    // Use ArrayList temporarily to mock the Database layer
    public static List<Customer> list = new ArrayList<Customer>();
    Random rand = new Random();
    
    
    // ADD ADDITIONAL FUNCTIONS
    
   
    /**
     * Creates a new customer record
     * @param id    
     * @param firstname
     * @param lastname
     * @param address
     * @param email
     * @param password 
     * @param accountType 
     */
    public void addCustomer(String firstname, String lastname, String address, String email, String password, int accountType) {
        Customer customer = new Customer(firstname, lastname, address,email, password);
        list.add(customer);
        
        // create account for the customer
        
        // generate an account number
        String accountNumber = Integer.toString(rand.nextInt());
        AccountService accountService = new AccountService();
        
        accountService.addAccount(accountType, accountType, accountNumber);
        
        System.out.println("New Customer registration completed.");
        
    }

    /**
     * Returns all customers on the platform
     * @return 
     */
    public List<Customer> getAllCustomers() {
        return list;
    }

    // Return a specific user of the service
    public Customer getCustomer(int id) {
        
        try {
            list.get(id - 1);
        } catch(IndexOutOfBoundsException Ex) {
            System.out.println(Ex.getMessage());
            return null;
        }
        return list.get(id - 1);
    }
    
}
