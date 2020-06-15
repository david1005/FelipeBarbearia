/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fjn.barbearia.intercepts;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.edu.fjn.barbearia.anotacao.Private;
import br.edu.fjn.barbearia.components.UsuarioSession;
import br.edu.fjn.barbearia.controllers.HomeController;
import br.edu.fjn.barbearia.controllers.LoginClienteController;
import javax.inject.Inject;
/**
 *
 * @author david
 */
@Intercepts
public class LoginIntercept implements Interceptor {
    
    @Inject
    private UsuarioSession usuarioSession;
    @Inject
    private Result result;

  @Override
    public void intercept(InterceptorStack is, ControllerMethod cm, Object o) throws InterceptionException {
            if(usuarioSession.logado()){
                is.next(cm, o);
            }else{
                
                result.redirectTo(HomeController.class).home();                                
            }
    }

    @Override
    public boolean accepts(ControllerMethod cm) {
        return !cm.containsAnnotation(Private.class);
    }        
    
    
    
}
