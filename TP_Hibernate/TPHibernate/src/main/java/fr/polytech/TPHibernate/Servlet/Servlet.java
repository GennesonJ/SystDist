package fr.polytech.TPHibernate.Servlet;

import fr.polytech.TPHibernate.Servlet.Metier.Compétence;
import fr.polytech.TPHibernate.Servlet.Metier.Equipement;
import fr.polytech.TPHibernate.Servlet.Metier.Perso;
import fr.polytech.TPHibernate.Servlet.DBManager.PersoManager;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/perso")
public class Servlet extends HttpServlet {

    private PersoManager pm;

    //GET pour recup tous les perso
    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Perso> getPerso() {
        pm = new PersoManager();
        return pm.getAll();
    }

    //POST pour créer un perso
    @POST
    @Path("postPerso")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Perso postPerso(Perso p) {
        pm = new PersoManager();
        return pm.create(p);
    }

    //POST pour créer une compétence
    @POST
    @Path("postComp")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Compétence postComp(Compétence c) {
        pm = new PersoManager();
        return pm.addCommpetence(c);
    }

    //POST pour créer un equipement
    @POST
    @Path("postEquip/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Perso postEquip(Equipement e,@PathParam(value="id") int id) {
        pm = new PersoManager();
        return pm.addEquipement(e,id);
    }

    //PUT pour update un perso
    @PUT
    @Path("put")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Perso updatePerso(Perso p) {
        pm = new PersoManager();
        return pm.update(p);
    }

    //DELETE pour suppr un perso
    @DELETE
    @Path("del")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Perso deletePerso(Perso p) {
        pm = new PersoManager();
        return pm.delete(p);
    }

}