package br.ucb.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carrinho implements Serializable{

	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private List<Item> itens;
	
	public Carrinho(){
		this.itens = new ArrayList<Item>();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public void addItem(Item item){
		this.itens.add(item);
	}
}
