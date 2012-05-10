package br.ucb.managedBean;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.hibernate.exception.ConstraintViolationException;

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
	
	
	public String isLogin(){
		
		this.usuarios = new UsuarioSistemaHIB().listar();
	
		if(usuarios.contains(usuario)){
			return "autorizado";
		}
		JSFMensageiro.error("Login ou senha invalido!");
		return "naoAutorizado";

	}
	
	public String salvar() {
		if (this.usuario.getNome().length() < 5) {
			JSFMensageiro.error("formulario:nome", "Nome incompleto!", "O nome dever ter no minimo de 5 caracteres");
			return "erro";
		}
		else {
			if (this.usuario.getId() == 0)
				JSFMensageiro.info("Usuario incluido com sucesso!");
			else
				JSFMensageiro.info("Usuario alterado com sucesso!");
			new UsuarioSistemaHIB().salvar(this.usuario);
		
			return listar();
		}
	}
	
	public String listar(){
		this.usuario = new UsuarioSistema();
		this.usuarios = new UsuarioSistemaHIB().listar();
		return "/restrito/usuarioSistemaLista";
	}
	
	public void excluir(ActionEvent evento) {
		this.usuario = (UsuarioSistema) evento.getComponent().getAttributes().get("usuario");
		try {
			new UsuarioSistemaHIB().excluir(this.usuario);
			JSFMensageiro.info("Usuario excluido com sucesso!");
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			JSFMensageiro.error("Erro inesperado ao excluir usuario!");
		}		
		
		this.usuario = new UsuarioSistema();
		this.usuarios = new UsuarioSistemaHIB().listar();
	}
	
	public String incluir(){
		return "/restrito/usuarioSistemaForm";
	}
	
	
}
