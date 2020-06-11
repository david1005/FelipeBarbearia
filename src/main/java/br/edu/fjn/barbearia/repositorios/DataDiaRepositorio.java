/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fjn.barbearia.repositorios;

import br.edu.fjn.barbearia.model.DataDia;
import br.edu.fjn.barbearia.util.FabricaDeConexao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author david
 */
public class DataDiaRepositorio {

    public void salvar(DataDia data) {
        EntityManager manager = FabricaDeConexao.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(data);// insert
            manager.getTransaction().commit();// ENCERRA TRANSAÇÃO SALVANDOS OS DADOS 
        } catch (Exception e) {
            manager.getTransaction().rollback();// ENCERRA TRANSAÇÃO DESFAZENDO  AS ALTERAÇÕES.  
        }
        manager.close();
    }

    public void atualizar(DataDia data) {
        EntityManager manager = FabricaDeConexao.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(data);// update
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();// "REVERTER"caso aconteça falha na hora de salvar
            System.out.println("Nosso Tratamento" + e.getMessage());
        }
        manager.close();
    }

    public void deletar(DataDia data) {
        EntityManager manager = FabricaDeConexao.getEntityManager();

        try {
            manager.getTransaction().begin();
            DataDia d = manager.find(DataDia.class, data.getId());
            manager.remove(d);// deletar
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
        manager.close();
    }

    public DataDia buscarPorId(Integer id) {
        EntityManager em = FabricaDeConexao.getEntityManager();
        DataDia d = em.find(DataDia.class, id);
        em.clear();
        return d;
    }

    // LISTA TODAS AS DATAS
    public List<DataDia> list() {
        EntityManager em = FabricaDeConexao.getEntityManager();
        try {
            List<DataDia> data = em.createQuery("from DataDia", DataDia.class).getResultList();
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

}
