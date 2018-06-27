/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avaliacao;
 
/**
 * Root resource (exposed at "myresource" path)
 */
import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
 
/**
 * Root resource (exposed at "myresource" path)
 */
@Path("presiswiki")
public class JerseyExemploController {

    PresidenciavelDAO pessoaDAO = new PresidenciavelDAO();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String olaMundo() {
        return "Seja bem-vindo ao PresisWiki, um sistema com informações"
                + " gerais sobre os presidenciáveis!";
    }
    
    @GET
    @Path("insert")
    public Response insert(@QueryParam("nome") String nome, 
                              @QueryParam("partido") String partido){
        Presidenciavel p = new Presidenciavel(nome,partido);
        this.pessoaDAO.insert(p);
        return Response.status(Status.OK).build();    
    }
    
    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@QueryParam("id") int id){
        Presidenciavel p = new Presidenciavel(id);
        p = this.pessoaDAO.get(p);
        return new Gson().toJson(p, Presidenciavel.class);
        
    }
    
 
}

