package br.ucb.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ucb.beans.Venda;
import br.ucb.util.HibernateUtil;


public class VendaHIB {
	
	
	public void salvar(Venda venda){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(venda);
		tx.commit();
		session.close();
	}
		
	@SuppressWarnings("unchecked")
	public List<Venda> listar(){
		
		Session session = HibernateUtil.getSession();
		try{
			return session.createQuery("from Venda").list();
		}finally{
			session.close();
		}
		
	}

}
