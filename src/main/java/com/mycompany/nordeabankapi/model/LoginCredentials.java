/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nordeabankapi.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginCredentials {

    private String email;
    private String password;

    public LoginCredentials() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
