package br.ucb.beans;

import java.io.Serializable;

public class Item implements Serializable{

	private static final long serialVersionUID = 1L;
	private int quantidade;
	private Produto produto;
	
	public Item(){
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}	

}
