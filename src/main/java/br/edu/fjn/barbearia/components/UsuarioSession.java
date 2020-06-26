/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fjn.barbearia.components;


import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
/**
 *
 * @author david
 */
@SessionScoped

public class UsuarioSession implements Serializable {
    
     private boolean logado;
     
  
 
    
    public boolean logado() {   
        
        return logado;
    }
    
  

    public void setLogado(boolean logado) {
        this.logado = logado;
    }  
    
}
