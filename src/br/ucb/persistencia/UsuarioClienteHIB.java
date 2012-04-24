package br.ucb.persistencia;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
	
}
