/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fjn.barbearia.repositorios;

import br.edu.fjn.barbearia.model.DataDia;
import br.edu.fjn.barbearia.model.Usuario;
import br.edu.fjn.barbearia.util.FabricaDeConexao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author david
 */
public class UsuarioRepositorio {
    
    public void salvar(Usuario user) {
        EntityManager manager = FabricaDeConexao.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(user);// insert
            manager.getTransaction().commit();// ENCERRA TRANSAÇÃO SALVANDOS OS DADOS 
        } catch (Exception e) {
            manager.getTransaction().rollback();// ENCERRA TRANSAÇÃO DESFAZENDO  AS ALTERAÇÕES.  
        }
        manager.close();
    }

    public void atualizar(Usuario user) {
        EntityManager manager = FabricaDeConexao.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(user);// update
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();// "REVERTER"caso aconteça falha na hora de salvar
            System.out.println("Nosso Tratamento" + e.getMessage());
        }
        manager.close();
    }

    public void deletar(Usuario user) {
        EntityManager manager = FabricaDeConexao.getEntityManager();

        try {
            manager.getTransaction().begin();
            DataDia d = manager.find(DataDia.class, user.getId());
            manager.remove(d);// deletar
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
        manager.close();
    }

    public Usuario buscarPorId(Integer id) {
        EntityManager em = FabricaDeConexao.getEntityManager();
        Usuario u = em.find(Usuario.class, id);
        em.clear();
        return u;
    }

    // LISTA TODAS AS DATAS
    public List<Usuario> list() {
        EntityManager em = FabricaDeConexao.getEntityManager();
        try {
            List<Usuario> user = em.createQuery("from Usuario", Usuario.class).getResultList();
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
     public List<Usuario> listId() {
        EntityManager em = FabricaDeConexao.getEntityManager();
        try {
            List<Usuario> user = em.createQuery("from Id", Usuario.class).getResultList();
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
    
}
