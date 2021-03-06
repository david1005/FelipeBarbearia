/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fjn.barbearia.repositorios;



import br.edu.fjn.barbearia.model.Usuario;
import br.edu.fjn.barbearia.util.FabricaDeConexao;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;    
/**
 *
 * @author david
 */
public class LoginRepositorio {
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
			System.out.println("Nosso Tratamento"+e.getMessage());
		}
		manager.close();
	}

	public Usuario buscarPorId(Integer id) {
		EntityManager em = FabricaDeConexao.getEntityManager();
		Usuario userFun = em.find(Usuario.class, id);
		em.clear();
		return userFun;
	}

        public Usuario buscarPorNome(String email){
            EntityManager em = FabricaDeConexao.getEntityManager();
            Session session = (Session) em.getDelegate();
            Criteria criteria = session.createCriteria(Usuario.class);
            criteria.add(Restrictions.ilike("email", email, MatchMode.EXACT));
            Usuario usuario = (Usuario) criteria.uniqueResult();
            em.close();
            return usuario;
        }
        
        public Usuario buscaPorNomeESenha(String email, String password){
            EntityManager em = FabricaDeConexao.getEntityManager();
            Session  session = (Session) em.getDelegate();
            Criteria criteria = session.createCriteria(Usuario.class);
            Criterion c1 = Restrictions.ilike("email",email, MatchMode.START);
            Criterion c2 = Restrictions.ilike("password", password, MatchMode.START);
            criteria.add(Restrictions.and(c1,c2));
            Usuario user = (Usuario) criteria.uniqueResult();
            em.close();
            return user;
        }
        
        
        public static Usuario buscarPorCpfESenha(String cpf, String password) {
        EntityManager em = FabricaDeConexao.getEntityManager();
        Usuario u = null;
        try {
            u = em.createQuery(
                    "select a from Usuario u where u.cpf = :cpf "
                    + "AND u.password = :password", Usuario.class)
                    .setParameter("cpf", cpf)
                    .setParameter("password", password)
                    .getSingleResult();
           
        } catch (NoResultException e) {
            u = null;
        }
        
        return u;
        
    }
    
}
