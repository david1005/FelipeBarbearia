/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fjn.barbearia.util;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author david
 */
public class FabricaDeConexao {
    
    //INTERFACE USADA PARA INTERAGIR COM A FABRICA DO GERENCIADOR DE ENTIDADES.
    private static  EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrmPU");
	
	
	public static EntityManager getEntityManager(){
            
                //CRIA E RETORNA UMA ENTIDADE 
		return emf.createEntityManager();
	}
        //METODO PARA FECHAR CONEXAO
	public static void close() {
		emf.close();
	}
}
