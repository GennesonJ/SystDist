package fr.polytech.TPRest.Servlet;

import fr.polytech.TPRest.Servlet.DBManager.PersoManager;
import fr.polytech.TPRest.Servlet.Metier.Perso;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/perso")
public class Servlet extends HttpServlet {

    private PersoManager pm;

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Perso> getPerso() {
        pm = new PersoManager();
        return pm.getAll();
    }

    @POST
    @Path("post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Perso postPerso(Perso p) {
        pm = new PersoManager();
        return pm.create(p);
    }

    @PUT
    @Path("put")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Perso updatePerso(Perso p) {
        pm = new PersoManager();
        return pm.update(p);
    }

    @DELETE
    @Path("del")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Perso deletePerso(Perso p) {
        pm = new PersoManager();
        return pm.delete(p);
    }

}