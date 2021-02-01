package fr.polytech.TPRest.Servlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloServlet extends HttpServlet {

    private static List<Product> list = new ArrayList<Product>() {{
        add(new Product("Tel", 200));
        add(new Product("Tab", 300));
        add(new Product("Ordi", 1200));
    }};

    @GET
    @Path("tousjson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> tousjson() {
        return list;
    }

    @GET
    @Path("tousxml")
    @Produces(MediaType.APPLICATION_XML)
    public List<Product> tousxml() {
        return list;
    }


    @GET
    @Path("sayHello")
    public String sayHello() {
        return "hello";
    }

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response addPerson(Person person) {
        return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
    }

    @GET
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response getPerson(Person person) {
        return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
    }

    @PUT
    @Path("put")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response putPerson(Person person) {
        return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
    }

    @DELETE
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response deletePerson(Person person) {
        return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
    }
}