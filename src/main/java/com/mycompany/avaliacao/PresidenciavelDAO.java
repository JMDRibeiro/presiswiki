/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avaliacao;

import java.util.ArrayList;

/**
 *
 * @author Joao Marcelo
 */
public class PresidenciavelDAO {
    private static PresidenciavelDAO uniqueInstance;
    static int id;
    static private ArrayList<Presidenciavel> presidenciaveis;
    
    private PresidenciavelDAO(){
        id = 1;
        this.presidenciaveis = new ArrayList<Presidenciavel>();
        Presidenciavel p1 = new Presidenciavel("João","PSD","Governador",25);
        insert(p1);
        Presidenciavel p2 = new Presidenciavel("ACM Neto","DEM","Governador",19.5);
        insert(p2);
        Presidenciavel p3 = new Presidenciavel("Lula","PT","Presidente",25);
        insert(p3);
    }
    
     public static PresidenciavelDAO getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new PresidenciavelDAO();

        return uniqueInstance;
    }
    public boolean insert(Presidenciavel presidenciavel){
        presidenciavel.id = id;
        id++;
       return  this.presidenciaveis.add(presidenciavel);
    }
    
    public boolean delete(Presidenciavel presidenciavel){
        int index = findIndex(presidenciavel);
        this.presidenciaveis.remove(index);
        return true;
    }
    
    public Presidenciavel update(Presidenciavel presidenciavel){
        int index = findIndex(presidenciavel);
        presidenciaveis.set(index,presidenciavel);
        return get(presidenciavel);
    }
    
    public Presidenciavel update(Presidenciavel presidenciavel,double percentualMedio){
        get(presidenciavel).percentualMedioPesquisas = percentualMedio;
        return get(presidenciavel);
    }
    
    public Presidenciavel get(Presidenciavel presidenciavel){
        presidenciavel = presidenciaveis.get(findIndex(presidenciavel));
        return  presidenciaveis.get(findIndex(presidenciavel));
    }
    
    public ArrayList<Presidenciavel> listAll(){
        return this.presidenciaveis;
    }
    
    public int size(){
        return this.presidenciaveis.size();
    }
    
    public int findIndex(Presidenciavel presidenciavel){
    int index = -1;
    for(int i=0;i<presidenciaveis.size();i++){
        if(presidenciaveis.get(i).id == presidenciavel.id){
            index = i;
        }
    }
    return index;
    
    }
}