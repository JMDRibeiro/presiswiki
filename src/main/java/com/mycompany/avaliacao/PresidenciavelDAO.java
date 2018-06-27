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
    private ArrayList<Presidenciavel> presidenciaveis;
    
    public PresidenciavelDAO(){
        this.presidenciaveis = new ArrayList<Presidenciavel>();
    }
    
    public boolean insert(Presidenciavel presidenciavel){
        presidenciavel.id = id;
        id++;
       return  this.presidenciaveis.add(presidenciavel);
    }
    
    public Presidenciavel get(Presidenciavel presidenciavel){
        for(int i=0;i<this.presidenciaveis.size();i++){
            if(this.presidenciaveis.get(i).id==presidenciavel.id)
                return this.presidenciaveis.get(i);
        }
       return  presidenciavel;
    }
}