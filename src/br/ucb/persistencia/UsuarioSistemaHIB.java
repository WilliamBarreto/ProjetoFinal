package br.ucb.persistencia;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ucb.beans.UsuarioSistema;
import br.ucb.util.HibernateUtil;

public class UsuarioSistemaHIB {
	
	public void Salvar(UsuarioSistema usuario){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(usuario);
		tx.commit();
		session.close();		
	}

}
