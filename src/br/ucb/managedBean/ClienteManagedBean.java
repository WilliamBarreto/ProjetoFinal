package br.ucb.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.hibernate.exception.ConstraintViolationException;

import br.ucb.beans.Cliente;
import br.ucb.beans.Usuario;
import br.ucb.beans.UsuarioCliente;
import br.ucb.persistencia.ClienteHIB;
import br.ucb.persistencia.UsuarioClienteHIB;
import br.ucb.util.JSFMensageiro;

public class ClienteManagedBean {

	private UsuarioCliente usuario;
	private Cliente cliente;
	private List<Cliente> clientes;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Cliente> getClientes() {
		return (ArrayList<Cliente>) clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ClienteManagedBean(){
		this.cliente = new Cliente();
		this.clientes = new ArrayList<Cliente>();
	}
	
	public String salvar() {
			this.usuario = new UsuarioCliente();
			usuario.setNome(cliente.getEmail());
			usuario.setSenha(Usuario.geraSenha());			
			
			this.cliente.setUsuario(this.usuario);
			
//			System.out.println(cliente.getNome());
//			System.out.println(cliente.getBairro());
//			System.out.println(cliente.getCep());
//			System.out.println(cliente.getCidade());
//			System.out.println(cliente.getCpf());
//			System.out.println(cliente.getEmail());
//			System.out.println(cliente.getLogradouro());
//			System.out.println(cliente.getUsuario().getNome());
//			System.out.println(cliente.getUsuario().getSenha());
	
			new UsuarioClienteHIB().salvar(usuario);
			new ClienteHIB().salvar(this.cliente);
			return "sucesso";
	}
	
		
		
	public String listar() {
		this.cliente= new Cliente();
		this.clientes =  (ArrayList<Cliente>) new ClienteHIB().listar();
		return "cliente";
	}
	
	public void excluir(ActionEvent evento) {
		this.cliente = (Cliente) evento.getComponent().getAttributes().get("cliente");
		try {
			new ClienteHIB().excluir(this.cliente);
			JSFMensageiro.info("Cliente excluido com sucesso!");
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			JSFMensageiro.error("Erro inesperado ao excluir usuario!");
		}		
		this.cliente = new Cliente();
		this.clientes = (ArrayList<Cliente>) new ClienteHIB().listar();
		
	}
}

