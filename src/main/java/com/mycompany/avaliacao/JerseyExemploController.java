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
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.PUT;
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

    PresidenciavelDAO presidenciavelDAO = new PresidenciavelDAO();
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
    @Produces(MediaType.TEXT_PLAIN)
    public String insert(@QueryParam("nome") String nome, 
                              @QueryParam("partido") String partido){
        Presidenciavel p = new Presidenciavel(nome,partido);
        this.presidenciavelDAO.insert(p);
        return this.presidenciavelDAO.size()+"";    
    }
    
    @GET
    @Path("get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@QueryParam("id") int id){
        System.out.println("Id passado: "+id);
        Presidenciavel p = new Presidenciavel(id);
        System.out.println("Id presidenciavel: "+p.id);
        p = this.presidenciavelDAO.get(p);
        System.out.println("Nome "+p.nome);
        return new Gson().toJson(p);
    }
    
    @GET
    @Path("update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("id") int id){
        Presidenciavel p = new Presidenciavel(1);
        p.nome = "Maria";
        this.presidenciavelDAO.update(p);
        return "atualize" ;
    }
 
    @GET
    @Path("listAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String listAll(){
        return new Gson().toJson(presidenciavelDAO.listAll());
    }
}

