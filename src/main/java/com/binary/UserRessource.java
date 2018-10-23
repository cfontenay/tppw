package com.binary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/user")
public class UserRessource {

    @GET
    @Path("/firstname")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFirstName(){
        User user = new User("Ali", "CHERIFI");
        try {
            return new ObjectMapper().writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/lastname")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLastName(){
        User user = new User("Ali", "CHERIFI");
        try {
            return new ObjectMapper().writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }




}
