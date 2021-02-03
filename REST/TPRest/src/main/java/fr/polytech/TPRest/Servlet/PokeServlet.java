package fr.polytech.TPRest.Servlet;

import fr.polytech.TPRest.Servlet.DBManager.PokemonManager;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/poke")
public class PokeServlet extends HttpServlet {

    private PokemonManager pm;

    @GET
    @Path("tous")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pokemon> getPokemon() {
        pm = new PokemonManager();
        return pm.getAll();
    }



//    @POST
//    @Path("post")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response addPokemon(Pokemon pokemon) {
//        return Response.ok().entity(pokemon).cookie(new NewCookie("pokemon", pokemon.toString())).build();
//    }
//
//    @GET
//    @Path("get")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getPokemon(Pokemon pokemon) {
//        return Response.ok().entity(pokemon).cookie(new NewCookie("pokemon", pokemon.toString())).build();
//    }
//
//    @PUT
//    @Path("put")
//    public Response putPokemon(Pokemon pokemon) {
//        return Response.ok().entity(pokemon).cookie(new NewCookie("pokemon", pokemon.toString())).build();
//    }
//
//    @DELETE
//    @Path("delete")
//    public Response deletePokemon(Pokemon pokemon) {
//        return Response.ok().entity(pokemon).cookie(new NewCookie("pokemon", pokemon.toString())).build();
//    }
}