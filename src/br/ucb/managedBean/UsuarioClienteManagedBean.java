package br.ucb.managedBean;

import br.ucb.beans.UsuarioCliente;
import br.ucb.persistencia.UsuarioClienteHIB;

public class UsuarioClienteManagedBean {
	
	private UsuarioCliente usuario;
	
	public UsuarioClienteManagedBean(){
		this.usuario = new UsuarioCliente();
	}
	
	public UsuarioCliente getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioCliente usuario) {
		this.usuario = usuario;
	}	
	
	public String salvar(){
		new UsuarioClienteHIB().salvar(this.usuario);
		return "sucesso";
	}
	
}
