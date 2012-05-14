package br.ucb.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.hibernate.exception.ConstraintViolationException;

import br.ucb.beans.Autorizacao;
import br.ucb.beans.Carrinho;
import br.ucb.beans.Cliente;
import br.ucb.beans.Item;
import br.ucb.beans.Produto;
import br.ucb.beans.UsuarioCliente;
import br.ucb.persistencia.AutorizacaoHIB;
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
	private Item item;
	private Carrinho carrinho;
	private boolean logado;
	private List<Autorizacao> autorizacoes;
	
	
	

	public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	public UsuarioClienteManagedBean(){
		this.usuario = new UsuarioCliente();
		this.usuarios = new ArrayList<UsuarioCliente>();
		this.produtos = new ProdutoHIB().listar();
		this.produto = new Produto();
		this.carrinho = new Carrinho();
		this.logado = false;
		this.autorizacoes = new AutorizacaoHIB().listar();
	}
	
	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
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
	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
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
			this.logado = true;
			this.carrinho = new Carrinho();
			return "index";
		}
		this.status="Situação: Deslogado";
		this.usuario = new UsuarioCliente();
		return "index";
	}

	public void addProduto(ActionEvent evento){
		
		if(this.logado){
		this.produto = (Produto) evento.getComponent().getAttributes().get("produto");
		
//		System.out.println("Produto");
//		System.out.println(this.quantidade);
//		System.out.println(this.produto.getId());
//		System.out.println(this.produto.getNome());
//		System.out.println(this.produto.getMarca());
//		System.out.println(this.produto.getPreco());
		this.item = new Item();
		this.item.setProduto(this.produto);
		this.item.setQuantidade(this.quantidade);
		
//		System.out.println("Item");
//		System.out.println(this.item.getProduto().getNome());
//		System.out.println(this.item.getQuantidade());
		
		this.carrinho.addItem(this.item);
		
		this.quantidade = 0;
		this.item = new Item();
		this.produto = new Produto();
		this.produtos = new ProdutoHIB().listar();
		}else{
			System.out.println("Burro! Tem que logar karai");
		}
		
	}

}
