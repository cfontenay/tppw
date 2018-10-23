package com.binary;



import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

@Path("/home")
public class HelloWorldResource {

    @Context
    ServletContext context;

    public HelloWorldResource(@Context ServletContext servletContext){
        this.context = servletContext;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public InputStream getHelloWorld() {
        return context.getResourceAsStream("index.html");
    }
}