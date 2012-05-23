package br.ucb.persistencia;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ucb.beans.VendaProduto;
import br.ucb.util.HibernateUtil;

public class VendaProdutoHIB {

	public void salvar(VendaProduto vendaProduto){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(vendaProduto);
		tx.commit();
		session.close();
	}
		
	
}
