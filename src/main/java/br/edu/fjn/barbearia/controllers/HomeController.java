/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fjn.barbearia.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.edu.fjn.barbearia.anotacao.Private;

/**
 *
 * @author david
 */

@Controller
public class HomeController {
    
    @Private
    @Get("/")
    public void home(){
        
    }
    
    
   
    
}
