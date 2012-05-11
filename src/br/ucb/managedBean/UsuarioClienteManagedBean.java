package br.ucb.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.hibernate.exception.ConstraintViolationException;

import br.ucb.beans.Cliente;
import br.ucb.beans.Produto;
import br.ucb.beans.UsuarioCliente;
import br.ucb.persistencia.ClienteHIB;
import br.ucb.persistencia.ProdutoHIB;
import br.ucb.persistencia.UsuarioClienteHIB;
import br.ucb.util.JSFMensageiro;

public class UsuarioClienteManagedBean {

	private UsuarioCliente usuario;
	private Cliente cliente;
	private List<Cliente>clientes;
	private List<UsuarioCliente> usuarios;
	private List<Produto>produtos;
	private String status;
	private Produto produto;
	private int quantidade;
	
	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public UsuarioClienteManagedBean(){
		this.usuario = new UsuarioCliente();
		this.usuarios = new ArrayList<UsuarioCliente>();
		this.produtos = new ProdutoHIB().listar();
		this.produto = new Produto();
	}
	
	
	public List<Produto> getProdutos() {
		return produtos;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<UsuarioCliente> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioCliente> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioCliente getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioCliente usuario) {
		this.usuario = usuario;
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
			return listar();
		}
	}

	
	public String listar() {
		this.usuario= new UsuarioCliente();
		this.usuarios =  (ArrayList<UsuarioCliente>) new UsuarioClienteHIB().listar();
		return "/restrito/usuarioClienteLista";
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
	
	public String incluir(){
		return "/restrito/usuarioClienteForm";
	}
	
	public String isLogin(){
		
		this.usuarios = new UsuarioClienteHIB().listar();
		
		if(this.usuarios.contains(this.usuario)){
			this.status="Situação: Logado";
			cliente = new Cliente();
			this.clientes = new ClienteHIB().listar();
			
			
			for (Cliente c : clientes) {
				System.out.println(c.getUsuario().getNome());
				System.out.println(this.usuario.getNome());
				if(c.getUsuario().getNome().equals(this.usuario.getNome())){
					this.cliente = c;
				}
			}	
			return "index";
		}
		this.status="Situação: Deslogado";
		this.usuario = new UsuarioCliente();
		return "index";
	}

	public void imprimir(ActionEvent evento){
		this.produto = (Produto) evento.getComponent().getAttributes().get("produto");
		
		System.out.println(this.quantidade);
		try {
			System.out.println(this.produto.getNome());
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		this.produto = new Produto();
		this.produtos = new ProdutoHIB().listar();
	}

}
