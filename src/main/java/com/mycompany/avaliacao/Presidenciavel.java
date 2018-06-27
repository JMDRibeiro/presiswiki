/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avaliacao;

/**
 *
 * @author Joao Marcelo
 */
public class Presidenciavel {
       String nome;
       String partido;
       String bordao;
       String ultimoCargo;
       double percentualMedioPesquisas;
       int id;
       
    Presidenciavel(String nome) {
           this.nome = nome;
    }

    Presidenciavel(String nome, String partido) {
           this.nome = nome;
           this.partido = partido;
    }
    
    Presidenciavel(String nome, String partido,String bordao,String ultimoCargo,double percentualMedioPesquisas) {
           this.nome = nome;
           this.partido = partido;
           this.bordao = bordao;
           this.ultimoCargo= ultimoCargo;
           this.percentualMedioPesquisas = percentualMedioPesquisas;
    }
    
    Presidenciavel(int id) {
           this.id = id;
    }
}
