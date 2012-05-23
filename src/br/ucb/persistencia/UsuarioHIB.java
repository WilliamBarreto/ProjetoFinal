package br.ucb.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.ucb.beans.Usuario;
import br.ucb.util.HibernateUtil;

public class UsuarioHIB {
	
	public void salvar(Usuario usuario){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(usuario);
		tx.commit();
		session.close();		
	}
	
	
	@SuppressWarnings("unchecked")
	public  List<Usuario> listar() {
		Session session = HibernateUtil.getSession();
		try {
			return	session.createCriteria(Usuario.class).addOrder(Order.asc("login")).list();
		} finally {
			session.close();
		}
	}
	
	public void excluir(Usuario usuario) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(usuario);
		tx.commit();
		session.close();
	}
}
