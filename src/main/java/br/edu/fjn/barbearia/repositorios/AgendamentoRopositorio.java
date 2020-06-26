/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fjn.barbearia.repositorios;

import br.edu.fjn.barbearia.components.UsuarioSession;
import br.edu.fjn.barbearia.model.Agendamento;
import br.edu.fjn.barbearia.model.Usuario;
import br.edu.fjn.barbearia.util.FabricaDeConexao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author david
 */
public class AgendamentoRopositorio {

    public void salvar(Agendamento agendamento) {
        EntityManager manager = FabricaDeConexao.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(agendamento);// insert
            manager.getTransaction().commit();// ENCERRA TRANSAÇÃO SALVANDOS OS DADOS 

        } catch (Exception e) {
            manager.getTransaction().rollback();// ENCERRA TRANSAÇÃO DESFAZENDO  AS ALTERAÇÕES. 

        }
        manager.close();

    }

    public void atualizar(Agendamento agendamento) {
        EntityManager manager = FabricaDeConexao.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(agendamento);// update
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();// "REVERTER"caso aconteça falha na hora de salvar
            System.out.println("Nosso Tratamento" + e.getMessage());
        }
        manager.close();
    }

    public void deletar(Agendamento agendamento) {
        EntityManager manager = FabricaDeConexao.getEntityManager();

        try {
            manager.getTransaction().begin();
            Agendamento a = manager.find(Agendamento.class, agendamento.getId());
            manager.remove(a);// deletar
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
        manager.close();
    }

    public Agendamento buscarPorId(Integer id) {
        EntityManager em = FabricaDeConexao.getEntityManager();
        Agendamento a = em.find(Agendamento.class, id);
        em.clear();
        return a;
    }

    public List<Agendamento> list() {

        EntityManager em = FabricaDeConexao.getEntityManager();
        try {
            List<Agendamento> agendamento = em.createQuery("from Agendamento", Agendamento.class).getResultList();
            return agendamento;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

  
    }
