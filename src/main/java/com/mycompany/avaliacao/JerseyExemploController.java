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
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@QueryParam("nome") String nome,@QueryParam("partido") String partido,
                         @QueryParam("ultimoCargo") String ultimoCargo,@QueryParam("percentualMedioPesquisas")double percentualMedioPesquisas){
        Presidenciavel p = new Presidenciavel(nome,partido,ultimoCargo,percentualMedioPesquisas);
        PresidenciavelDAO.getInstance().insert(p);
        return new Gson().toJson(p);    
    }
    
    @GET
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(@QueryParam("id") int id){
        Presidenciavel p = new Presidenciavel(id);
        PresidenciavelDAO.getInstance().delete(p);
        return listAll();    
    }
    
    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@QueryParam("id") int id){
        Presidenciavel p = new Presidenciavel(id);
        p = PresidenciavelDAO.getInstance().get(p);
        System.out.println("Later the get:"+p.toString());
        return new Gson().toJson(p);
    }
    
    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("id") int id, @QueryParam("novoPercentualPesquisa") double novoPercentualPesquisa){
        Presidenciavel p = new Presidenciavel(id);
        PresidenciavelDAO.getInstance().update(p,novoPercentualPesquisa);
        return new Gson().toJson(p);
    }
 
    @GET
    @Path("listAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String listAll(){
        return new Gson().toJson(PresidenciavelDAO.getInstance().listAll());
    }
}

