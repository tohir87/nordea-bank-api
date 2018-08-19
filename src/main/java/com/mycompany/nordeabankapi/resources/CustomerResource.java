/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nordeabankapi.resources;

import com.mycompany.nordeabankapi.model.Customer;
import com.mycompany.nordeabankapi.model.LoginCredentials;
import com.mycompany.nordeabankapi.service.CustomerService;
import com.mycompany.nordeabankapi.service.Hasher;
import java.util.List;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author 
 */

@Path("/customers")
public class CustomerResource {
    
    CustomerService customerService = new CustomerService();
    Random rand = new Random();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }
    
    @GET
    @Path("/new")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response newCustomer(@Context UriInfo info) {
                
        try {
            
            // Get the user inputs when creating a new profile
            String firstname = info.getQueryParameters().getFirst("firstname");
            String lastname = info.getQueryParameters().getFirst("lastname");
            String address = info.getQueryParameters().getFirst("address");
            String email = info.getQueryParameters().getFirst("email");
            String password = info.getQueryParameters().getFirst("password");
            String accountType = info.getQueryParameters().getFirst("account_type");

            if (firstname.isEmpty() || lastname.isEmpty()
                    || address.isEmpty() || email.isEmpty()
                    || password.isEmpty() || accountType.isEmpty()) {

                // HOW TO RETURN FIELDS THAT HAVE MISSING VALUES?
                String output = "Please fill in all the fields";
                return Response.status(200).entity(output).build();
                
            }  else {
                
                customerService.addCustomer(firstname, lastname, address, email, password, Integer.parseInt(accountType));
                String output = "Welcome " + firstname + "!\nGet started by opening a new account";
                return Response.status(200).entity(output).build();
            }
        } catch (NullPointerException e){
            String output = "Error with the parameters passed";
            return Response.status(200).entity(output).build();
        }       
    }

    @GET
    @Path("/{customerId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Customer getCustomer(@PathParam("customerId") int id) {
        return customerService.getCustomer(id);
    }
    
    @POST
    @Path("/logout")
    public Response logout(@CookieParam("account") Cookie cookie) {
        if (cookie != null) {
            NewCookie nc = new NewCookie(cookie, null, 0, false);
            return Response.ok("Sucessfully logged out.").cookie(nc).build();
        }
        return Response.ok("Already logged out.").build();
    }
    
    @POST
    @Path("/login")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response login(@CookieParam("account") Cookie cookie, LoginCredentials loginCredentials) throws Hasher.CannotPerformOperationException {
        if (cookie != null) {
            return Response.serverError().entity("Already logged in.").build();
        }
        for (Customer c : customerService.getAllCustomers()) {
            if (c.getEmail().equals(loginCredentials.getEmail())) {
                if (c.getPassword().equals(Hasher.createHash(c.getPassword()))) {
                    
                    //Set a cookie in their browser and response accordingly
                    NewCookie nc = new NewCookie("account", Hasher.createHash(Integer.toString(c.getId())));
                    return Response.ok("Successfully logged in.").cookie(nc).build();
                } else //Incorrect password
                //Break and return the default message
                {
                    break;
                }
            }
        }

        return Response.serverError().entity("Invalid email or password.").build();
    }

    
}
