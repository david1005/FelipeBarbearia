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
import br.edu.fjn.barbearia.anotacao.Private;
import br.edu.fjn.barbearia.components.UsuarioSession;
import br.edu.fjn.barbearia.model.DataDia;
import br.edu.fjn.barbearia.model.Usuario;
import br.edu.fjn.barbearia.repositorios.DataDiaRepositorio;
import br.edu.fjn.barbearia.repositorios.LoginRepositorio;
import br.edu.fjn.barbearia.repositorios.UsuarioRepositorio;
import java.util.List;
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
    @Inject
    private UsuarioSession usuarioSession; 
    
    @Private
    @Get("login")
    public void login(){
        
    }
    
    @Private
    @Get("registrar")
    public void cadastro(){
        
    }
    
    
    
    
    
    @Private
    @Post("login")
    public void login(Usuario user){
        LoginRepositorio loginRepositorio = new LoginRepositorio();
        
        if(loginRepositorio.buscaPorNomeESenha(user.getUserName(), user.getPassword()) != null){
            usuarioSession.setLogado(true);
            result.redirectTo(AgendamentoController.class).agendamento();
        }else{
            result.include("mensagem", "Usuario ou senha incorretos.");
            result.redirectTo(this).login();
        }
    }
    
    @Private
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
    
      @Get("sair")
    public void sair() {
        usuarioSession.setLogado(false);
        result.redirectTo(HomeController.class).home();
    }
    
    
   
}
