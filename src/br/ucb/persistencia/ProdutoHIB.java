package br.ucb.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import br.ucb.beans.Produto;
import br.ucb.util.HibernateUtil;

public class ProdutoHIB {

	public void salvar(Produto produto){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(produto);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public  List<Produto> listar() {
		Session session = HibernateUtil.getSession();
		try {
			return	session.createCriteria(Produto.class).addOrder(Order.asc("nome")).list();
		} finally {
			session.close();
		}
	}
	public void excluir(Produto produto) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(produto);
		tx.commit();
		session.close();
	}
}
