package br.ucb.managedBean;

import java.util.Iterator;
import java.util.List;

import br.ucb.beans.UsuarioSistema;
import br.ucb.persistencia.UsuarioSistemaHIB;
import br.ucb.util.JSFMensageiro;

public class UsuarioSistemaManagedBean {

	private UsuarioSistema usuario;
	private List<UsuarioSistema> usuarios;
	
	
	public UsuarioSistemaManagedBean(){
		this.usuario = new UsuarioSistema();
	}
	public UsuarioSistema getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioSistema usuario) {
		this.usuario = usuario;
	}
	
	public List<UsuarioSistema> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<UsuarioSistema> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String salvar(){
		new UsuarioSistemaHIB().Salvar(this.usuario);
		return "recesso";		
	}
	
	public String isLogin(){
		
		this.usuarios = new UsuarioSistemaHIB().listar();
	
		if(usuarios.contains(usuario)){
			return "autorizado";
		}
		JSFMensageiro.error("Login ou senha invalido!");
		return "naoAutorizado";

	}
	
	
}
