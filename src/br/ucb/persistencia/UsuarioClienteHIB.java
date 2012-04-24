package br.ucb.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.ucb.beans.UsuarioCliente;
import br.ucb.util.HibernateUtil;

public class UsuarioClienteHIB {

	
	public void salvar(UsuarioCliente usuario){
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(usuario);
		tx.commit();
		session.close();		
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioCliente> listar() {
		Session session = HibernateUtil.getSession();
		try { 
			return session.createCriteria(UsuarioCliente.class).addOrder(Order.asc("nome")).list();
		} finally {
			session.close();
		}
	}
	
	public void excluir(UsuarioCliente usuario) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(usuario);
		tx.commit();
		session.close();
	}
	
	
	
}
