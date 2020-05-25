/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fjn.barbearia.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.barbearia.model.Usuario;
import br.edu.fjn.barbearia.repositorios.LoginRepositorio;
import javax.inject.Inject;

/**
 *
 * @author david
 */
@Controller
@Path("agendamento")
public class LoginClienteController {  
       
    @Inject
    private Result result;
     
    @Get("login")
    public void login(){
        
    }
    
    @Get("registrar")
    public void cadastro(){
        
    }
    
    
    
    
    @Post("login")
    public void login(Usuario user){
        LoginRepositorio loginRepositorio = new LoginRepositorio();
        
        if(loginRepositorio.buscaPorNomeESenha(user.getUserName(), user.getPassword()) != null){
            //funcionarioSession.setLogado(true);
            result.redirectTo(AgendamentoController.class).agendamento();
        }else{
            result.include("mensagem", "Usuario ou senha incorretos.");
            result.redirectTo(this).login();
        }
    }
    
    @Post("cadastrar")
    public void salvar(Usuario user){
        LoginRepositorio loginRepositorio = new LoginRepositorio();
        
        if(loginRepositorio.buscarPorNome(user.getUserName()) == null ){
            loginRepositorio.salvar(user);
            result.redirectTo(this).login();
        }else{
            result.include("mensagem","Usuário já existe.");
            result.redirectTo(this).cadastro();
        }               
    }
}
