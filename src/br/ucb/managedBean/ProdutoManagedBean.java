package br.ucb.managedBean;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;

import org.hibernate.exception.ConstraintViolationException;
import org.primefaces.event.FileUploadEvent;

import br.ucb.beans.Produto;
import br.ucb.persistencia.ProdutoHIB;
import br.ucb.util.JSFMensageiro;

public class ProdutoManagedBean {

	private Produto produto;
	private List<Produto> produtos;
	private String nome;
	private String arquivo;
	private byte[] foto;

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

	public String incluir(){
		return "/restrito/produtoForm";
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
			gravar();

			return listar();
		}
	}

	public String listar() {
		this.produto = new Produto();
		this.produtos = new ProdutoHIB().listar();
		return "/restrito/produtoLista";
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
	
	//upando a foto na memoria, só é gravada quando o metodo salvar é disparado;
	public void uploadAction (FileUploadEvent event){
		
		try {
			
			// pegando a foto
			foto = event.getFile().getContents();
			
			//pegando o nome da foto com o caminho
			nome = event.getFile().getFileName();
			
			//tirando o caminho
			String teste[] = nome.split("/");
			for (int i = 0; i < teste.length; i++) {
				if(i == teste.length){
					nome = teste[i];
				}
			}
			//pegando o caminho que a foto vai ser gravada
			FacesContext facesContext = FacesContext.getCurrentInstance();  
			ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();  
			arquivo = scontext.getRealPath("/resources/images/" + nome);
			
			//setando o nome da foto no banco
			this.produto.setFoto(nome);

		}catch (Exception ex){
			System.out.println("Erro no Upload");
		}
	}
		//gravar imagen na aplicação
		public void gravar(){
			FileOutputStream fos;
			try {
			//passando o caminho;	
			fos = new FileOutputStream(arquivo);
			//passando o arquivo;
			fos.write(foto);
			fos.close();
			
			} catch (FileNotFoundException ex) {
			Logger.getLogger(ProdutoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException ex) {
			Logger.getLogger(ProdutoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	}


