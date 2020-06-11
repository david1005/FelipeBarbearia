/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fjn.barbearia.repositorios;

import br.edu.fjn.barbearia.model.Funcionario;
import br.edu.fjn.barbearia.model.Servico;
import br.edu.fjn.barbearia.util.FabricaDeConexao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author david
 */
public class ServicoRepositorio {
    
     public void salvar(Servico servico) {
		EntityManager manager = FabricaDeConexao.getEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(servico);// insert
			manager.getTransaction().commit();// ENCERRA TRANSAÇÃO SALVANDOS OS DADOS 
		} catch (Exception e) {
			manager.getTransaction().rollback();// ENCERRA TRANSAÇÃO DESFAZENDO  AS ALTERAÇÕES.  
		}
		manager.close();
	}
    
    public void atualizar(Servico servico) {
		EntityManager manager = FabricaDeConexao.getEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(servico);// update
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();// "REVERTER"caso aconteça falha na hora de salvar
			System.out.println("Nosso Tratamento"+e.getMessage());
		}
		manager.close();
	}
    
     public void deletar(Servico servico) {
        EntityManager manager = FabricaDeConexao.getEntityManager();

        try {
            manager.getTransaction().begin();
            Servico s = manager.find(Servico.class, servico.getId());
            manager.remove(s);// deletar
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
        manager.close();
    }
    
     
        public Servico buscarPorId(Integer id) {
        EntityManager em = FabricaDeConexao.getEntityManager();
        Servico s = em.find(Servico.class, id);
        em.clear();
        return s;
    }
        
        
               // LISTA TODOS OS CLIENTE
    public List<Servico> list() {
        EntityManager em = FabricaDeConexao.getEntityManager();
        try {
            List<Servico> servico = em.createQuery("from Servico", Servico.class).getResultList();
            return servico;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
}
