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
    static int id;
    static private ArrayList<Presidenciavel> presidenciaveis;
    
    public PresidenciavelDAO(){
        id = 1;
        this.presidenciaveis = new ArrayList<Presidenciavel>();
        Presidenciavel p1 = new Presidenciavel("João","PSB","Estado eficiente, Brasil melhor pra gente","Governador",25);
        insert(p1);
        Presidenciavel p2 = new Presidenciavel("ACM Neto","DEM","Menos Estado, mais Brasil","Governador",19.5);
        insert(p2);
        Presidenciavel p3 = new Presidenciavel("Lula","PT","Brasil, um país de todos","Presidente",25);
        insert(p3);
    }
    
    public boolean insert(Presidenciavel presidenciavel){
        presidenciavel.id = id;
        id++;
       return  this.presidenciaveis.add(presidenciavel);
    }
    
    public boolean delete(Presidenciavel presidenciavel){
        int index = presidenciavel.id - 1;
        this.presidenciaveis.remove(index);
        return true;
    }
    
    public boolean update(Presidenciavel presidenciavel){
        for(int i=0;i<this.presidenciaveis.size();i++){
            if(this.presidenciaveis.get(i).id==presidenciavel.id)
                this.presidenciaveis.set(i,presidenciavel);
                return true;
        }
        return false;
    }
    
    public Presidenciavel get(Presidenciavel presidenciavel){
        for(int i=0;i<this.presidenciaveis.size();i++){
            if(this.presidenciaveis.get(i).id==presidenciavel.id)
                return this.presidenciaveis.get(i);
        }
       return  presidenciavel;
    }
    
    public int size(){
        return this.presidenciaveis.size();
    }
    
    public ArrayList<Presidenciavel> listAll(){
        return this.presidenciaveis;
    }
}