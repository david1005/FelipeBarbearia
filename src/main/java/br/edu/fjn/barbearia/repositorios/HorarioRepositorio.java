/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fjn.barbearia.repositorios;

import br.edu.fjn.barbearia.model.Horario;
import br.edu.fjn.barbearia.util.FabricaDeConexao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author david
 */
public class HorarioRepositorio {

    public void salvar(Horario horario) {
        EntityManager manager = FabricaDeConexao.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(horario);// insert
            manager.getTransaction().commit();// ENCERRA TRANSAÇÃO SALVANDOS OS DADOS 
        } catch (Exception e) {
            manager.getTransaction().rollback();// ENCERRA TRANSAÇÃO DESFAZENDO  AS ALTERAÇÕES.  
        }
        manager.close();
    }

    public void atualizar(Horario horario) {
        EntityManager manager = FabricaDeConexao.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(horario);// update
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();// "REVERTER"caso aconteça falha na hora de salvar
            System.out.println("Nosso Tratamento" + e.getMessage());
        }
        manager.close();
    }

    public void deletar(Horario horario) {
        EntityManager manager = FabricaDeConexao.getEntityManager();

        try {
            manager.getTransaction().begin();
            Horario h = manager.find(Horario.class, horario.getId());
            manager.remove(h);// deletar
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
        manager.close();
    }

    public Horario buscarPorId(Integer id) {
        EntityManager em = FabricaDeConexao.getEntityManager();
        Horario h = em.find(Horario.class, id);
        em.clear();
        return h;
    }

    // LISTA TODAS AS DATAS
    public List<Horario> list() {
        EntityManager em = FabricaDeConexao.getEntityManager();
        try {
            List<Horario> horario = em.createQuery("from Horario", Horario.class).getResultList();
            return horario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
}
