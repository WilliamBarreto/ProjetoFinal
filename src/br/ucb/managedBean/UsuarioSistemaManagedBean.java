package br.ucb.managedBean;

import br.ucb.beans.UsuarioSistema;
import br.ucb.persistencia.UsuarioSistemaHIB;

public class UsuarioSistemaManagedBean {

	private UsuarioSistema usuario;
	
	public UsuarioSistemaManagedBean(){
		this.usuario = new UsuarioSistema();
	}
	public UsuarioSistema getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioSistema usuario) {
		this.usuario = usuario;
	}
	
	public String salvar(){
		new UsuarioSistemaHIB().Salvar(this.usuario);
		return "recesso";		
	}
	
}
