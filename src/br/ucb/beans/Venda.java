package br.ucb.beans;

import java.io.Serializable;
import java.util.ArrayList;



public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private Cliente cliente;
	private ArrayList<Produto> produtos;
	
	public Venda(){
		this.cliente = new Cliente();
		this.produtos =  new ArrayList<Produto>();
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}
