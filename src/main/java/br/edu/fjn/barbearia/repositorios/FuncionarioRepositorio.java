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
public class FuncionarioRepositorio {
    
     public void salvar(Funcionario fun) {
		EntityManager manager = FabricaDeConexao.getEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(fun);// insert
			manager.getTransaction().commit();// ENCERRA TRANSAÇÃO SALVANDOS OS DADOS 
		} catch (Exception e) {
			manager.getTransaction().rollback();// ENCERRA TRANSAÇÃO DESFAZENDO  AS ALTERAÇÕES.  
		}
		manager.close();
	}
    
    public void atualizar(Funcionario fun) {
		EntityManager manager = FabricaDeConexao.getEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(fun);// update
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();// "REVERTER"caso aconteça falha na hora de salvar
			System.out.println("Nosso Tratamento"+e.getMessage());
		}
		manager.close();
	}
    
     public void deletar(Funcionario fun) {
        EntityManager manager = FabricaDeConexao.getEntityManager();

        try {
            manager.getTransaction().begin();
            Funcionario f = manager.find(Funcionario.class, fun.getId());
            manager.remove(f);// deletar
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
        manager.close();
    }
     
         public Funcionario buscarPorId(Integer id) {
        EntityManager em = FabricaDeConexao.getEntityManager();
        Funcionario f = em.find(Funcionario.class, id);
        em.clear();
        return f;
    }
         
            // LISTA TODOS OS FUNCIONARIOS
    public List<Funcionario> list() {
        EntityManager em = FabricaDeConexao.getEntityManager();
        try {
            List<Funcionario> funcionario = em.createQuery("from Funcionario", Funcionario.class).getResultList();
            return funcionario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
    
}
