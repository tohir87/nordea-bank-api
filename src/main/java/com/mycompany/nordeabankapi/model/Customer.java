package com.mycompany.nordeabankapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.*;

public class Customer implements Serializable, DAO {

    // Constructors
    public Customer() {
    }

    public Customer(String firstname, String lastname, String address, String email, String password) {
//        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.address = address;
        this.email = email;
        this.password = password;
        
        String sql = "INSERT INTO customers(first_name,last_name,email, address, password) "
                   + "VALUES(?,?,?,?,?)";
        
        ResultSet rs = null;

        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            // set parameters for statement
            pstmt.setString(1, this.firstName);
            pstmt.setString(2, this.lastName);
            pstmt.setString(3, this.email);
            pstmt.setString(4, this.address);
            pstmt.setString(5, this.password);
            
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {
                // get customer id
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
                this.id = rs.getInt(1);
 
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            // TODO: handle exception
            System.out.println(ex.getMessage());
        }

    }

    // Setters - Mutators
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters - Accessors
    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLasstname() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstname=" + firstName + ", lastname=" + lastName + ", address=" + address + ", email=" + email + ", password=" + password + '}';
    }

    public boolean hasAccount(int accId) {
        for (Account a : accounts) {
            if (a.getCustomerId() == accId) {
                return true;
            }
        }
        return false;
    }

    // Class Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;
    @OneToMany
    private List<Account> accounts = new ArrayList<>();
}
