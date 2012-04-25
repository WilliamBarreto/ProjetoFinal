package br.ucb.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.ucb.beans.UsuarioSistema;
import br.ucb.util.HibernateUtil;

public class UsuarioSistemaHIB {
	
	public void salvar(UsuarioSistema usuario){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(usuario);
		tx.commit();
		session.close();		
	}
	
	
	@SuppressWarnings("unchecked")
	public  List<UsuarioSistema> listar() {
		Session session = HibernateUtil.getSession();
		try {
			return	session.createCriteria(UsuarioSistema.class).addOrder(Order.asc("nome")).list();
		} finally {
			session.close();
		}
	}
	
	public void excluir(UsuarioSistema usuario) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(usuario);
		tx.commit();
		session.close();
	}
}
