package br.ucb.managedBean;

import java.util.ArrayList;

import javax.faces.event.ActionEvent;

import org.hibernate.exception.ConstraintViolationException;
import br.ucb.beans.UsuarioCliente;
import br.ucb.persistencia.UsuarioClienteHIB;
import br.ucb.util.JSFMensageiro;

public class UsuarioClienteManagedBean {
	
	private UsuarioCliente usuario;
	private ArrayList<UsuarioCliente> usuarios;
	
	public ArrayList<UsuarioCliente> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<UsuarioCliente> usuarios) {
		this.usuarios = usuarios;
	}
	
	public UsuarioCliente getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioCliente usuario) {
		this.usuario = usuario;
	}

	public UsuarioClienteManagedBean(){
		this.usuario = new UsuarioCliente();
		this.usuarios = new ArrayList<UsuarioCliente>();
	}
	
	public String salvar(){
		new UsuarioClienteHIB().salvar(this.usuario);
		return "sucesso";
	}
	
	public String listar() {
		this.usuario= new UsuarioCliente();
		this.usuarios =  (ArrayList<UsuarioCliente>) new UsuarioClienteHIB().listar();
		return "usuarioCliente";
	}
	
	public void excluir(ActionEvent evento) {
		this.usuario = (UsuarioCliente) evento.getComponent().getAttributes().get("usuario");
		try {
			new UsuarioClienteHIB().excluir(this.usuario);
			JSFMensageiro.info("Usuario excluido com sucesso!");
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			JSFMensageiro.error("Erro inesperado ao excluir usuario!");
		}		
		
		this.usuario = new UsuarioCliente();
		this.usuarios = (ArrayList<UsuarioCliente>) new UsuarioClienteHIB().listar();
		
	}
	
	
	
	
}
