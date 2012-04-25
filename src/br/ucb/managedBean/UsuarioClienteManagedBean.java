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
			new UsuarioClienteHIB().salvar(this.usuario);
			this.usuario = new UsuarioCliente();
			this.usuarios = (ArrayList<UsuarioCliente>) new UsuarioClienteHIB().listar();
			return "sucesso";
		}
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
