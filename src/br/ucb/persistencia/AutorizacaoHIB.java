package br.ucb.persistencia;

import java.util.List;

import org.hibernate.Session;

import br.ucb.beans.Autorizacao;
import br.ucb.util.HibernateUtil;


public class AutorizacaoHIB {
	
	@SuppressWarnings("unchecked")
	public List<Autorizacao>listar(){
		
		Session session = HibernateUtil.getSession();
		try{
			return session.createCriteria(Autorizacao.class).list();
		}finally{
			session.close();
		}
		
	}
	
	

}
