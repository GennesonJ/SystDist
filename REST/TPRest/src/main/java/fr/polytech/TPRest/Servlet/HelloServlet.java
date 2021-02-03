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

    public int somme(){
        return 5;
    }

    private static List<Product> list = new ArrayList<Product>() {{
        add(new Product(1, "Tel", 200));
        add(new Product(2, "Tab", 300));
        add(new Product(3, "Ordi", 1200));
    }};

    //méthode ajout de produit
    @POST
    @Path("ajouterUnProduit/{code}/{nom}/{price}")
    @Produces(MediaType.APPLICATION_XML)
    public Product ajouterUnProduit(@PathParam("code") int code, @PathParam("nom") String nom, @PathParam("price") double price) {
        Product p = new Product(code, nom, price);
        list.add(p);
        return p;
    }
    //Avec post man on rentre l'url : http://localhost:8080/TPRest_war_exploded/hello/ajouterUnProduit/4/Switch/250

    // ecrire une méthode qui permet d'ajouter un produit, passé en format XML
    @POST
    @Path("ajouterUnProduitBis")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Product ajouterUnProduitBis(Product p) {
        list.add(p);
        return p;
    }
    // http://localhost:8080/TPRest_war_exploded/hello/ajouterUnProduitBis
    // et dans body on met, par exemple xml (car @Consumes(XML)) avec un objet :
    /*
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <product>
        <code>4</code>
        <nom>Switch</nom>
        <prix>200.0</prix>
    </product>
    */

    //méthode suppr de produit
    @DELETE
    @Path("supprUnProduit/{code}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Product supprUnProduit(@PathParam("code")int code) {
        Product p = new Product();
        for (int i = 0; i < list.size(); i++) {
            if (code == list.get(i).getCode()) {
                p = list.get(i);
                list.remove(i);
            }
        }
        return p;
    }
    // http://localhost:8080/TPRest_war_exploded/hello/supprUnProduit/3

    //méthode maj de produit
    @PUT
    @Path("majUnProduit/{code}/{nom}/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product majUnProduit(@PathParam("code")int code, @PathParam("nom") String nom, @PathParam("price") double price) {
        Product p = new Product();
        Product newp = new Product(code, nom, price);
        for (int i = 0; i < list.size(); i++) {
            if (code == list.get(i).getCode()) {
                p = list.get(i);
                list.remove(i);
                list.add(newp);
            }
        }
        return newp;
    }
    // http://localhost:8080/TPRest_war_exploded/hello/majUnProduit/2/NewTab/3000


    //Dans le but d'illustrer la notion d'interopérabilité, on va définir un client
    //exemple sur Arche


        @GET
        @Path("tousjson")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Product> tousjson () {
            return list;
        }

        @GET
        @Path("tousxml")
        @Produces(MediaType.APPLICATION_XML)
        public List<Product> tousxml () {
            return list;
        }


        @GET
        @Path("sayHello")
        public String sayHello () {
            return "hello";
        }

        @POST
        @Path("post")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public javax.ws.rs.core.Response addPerson (Person person){
            return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
        }

        @GET
        @Path("get")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public javax.ws.rs.core.Response getPerson (Person person){
            return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
        }

        @PUT
        @Path("put")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public javax.ws.rs.core.Response putPerson (Person person){
            return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
        }

        @DELETE
        @Path("delete")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public javax.ws.rs.core.Response deletePerson (Person person){
            return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
        }
    }