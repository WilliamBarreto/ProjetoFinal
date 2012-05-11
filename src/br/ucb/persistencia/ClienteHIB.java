package br.ucb.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.ucb.beans.Cliente;
import br.ucb.beans.UsuarioCliente;
import br.ucb.util.HibernateUtil;

public class ClienteHIB {
	
	public void salvar(Cliente cliente){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(cliente);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listar() {
		Session session = HibernateUtil.getSession();
		try { 
			return session.createCriteria(Cliente.class).addOrder(Order.asc("nome")).list();
		} finally {
			session.close();
		}
	}
	
	public void excluir(Cliente cliente) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(cliente);
		tx.commit();
		session.close();
	}
	
	public Cliente buscaCliente(UsuarioCliente usuario){
		Cliente cliente;
		Session session = HibernateUtil.getSession();
		try{
			cliente =(Cliente) session.createCriteria(Cliente.class).add(Restrictions.eq("usuarioc_id_usuario_cliente", usuario.getId())); 
		}finally{
			session.close();
		}
		return cliente;
	}
}
