package br.ucb.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.hibernate.exception.ConstraintViolationException;

import br.ucb.beans.Produto;
import br.ucb.persistencia.ProdutoHIB;
import br.ucb.util.JSFMensageiro;

public class ProdutoManagedBean {

	private Produto produto;
	private List<Produto> produtos;
	
	public ProdutoManagedBean(){
		this.produto = new Produto();
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public ArrayList<Produto> getProdutos() {
		return (ArrayList<Produto>) produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public String salvar() {
		if (this.produto.getNome().length() < 5) {
			JSFMensageiro.error("formulario:nome", "Nome incompleto!", "O nome dever ter no minimo de 5 caracteres");
			return "erro";
		}
		else {
			if (this.produto.getId() == 0)
				JSFMensageiro.info("Produto incluido com sucesso!");
			else
				JSFMensageiro.info("Produto alterado com sucesso!");
			new ProdutoHIB().salvar(this.produto);
			this.produto = new Produto();
			this.produtos = new ProdutoHIB().listar();
			return "sucesso";
		}
	}
	
	public String listar() {
		this.produto = new Produto();
		this.produtos = new ProdutoHIB().listar();
		return "produto";
	}
	
	public void excluir(ActionEvent evento) {
		this.produto = (Produto) evento.getComponent().getAttributes().get("produto");
		try {
			new ProdutoHIB().excluir(this.produto);
			JSFMensageiro.info("Produto excluido com sucesso!");
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			JSFMensageiro.error("Erro inesperado ao excluir aluno!");
		}		
		this.produto = new Produto();
		this.produtos = (ArrayList<Produto>) new ProdutoHIB().listar();
		
	}
}