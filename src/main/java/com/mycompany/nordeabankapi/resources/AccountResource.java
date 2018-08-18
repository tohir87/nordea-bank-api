/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nordeabankapi.resources;

import com.mycompany.nordeabankapi.model.Account;
import com.mycompany.nordeabankapi.service.AccountService;
import java.util.List;
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author
 */
@Path("/account")
public class AccountResource {

    AccountService accountService = new AccountService();
    Random rand = new Random();

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Account> getAccounts() {
        return accountService.getAllAccounts();
    }

    @GET
    @Path("/{accountId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Account getAccount(@PathParam("accountId") int id) {
        return accountService.getAccount(id);
    }

    @GET
    @Path("/new")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response newAccount(@Context UriInfo info) {
        int customerId = Integer.parseInt(info.getQueryParameters().getFirst("customer_id"));
        int accountType = Integer.parseInt(info.getQueryParameters().getFirst("account_type"));

        // generate an account number
        String accountNumber = Integer.toString(rand.nextInt());

        accountService.addAccount(customerId, accountType, accountNumber);

        String output = "Success, account creation was successfully";
        return Response.status(200).entity(output).build();
    }

}
