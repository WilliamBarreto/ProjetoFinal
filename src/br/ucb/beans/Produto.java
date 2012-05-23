package br.ucb.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String marca;
	private Double preco;

	private String tipo;
	private String url;
	private Collection<VendaProduto>vendaProdutoList;

	private String foto;
	
	@GeneratedValue
	@Id
	@Column(name="id_produto")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="marca")
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	@Column(name="preco")
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	@Column(name="tipo")
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Column(name="url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@OneToMany(mappedBy="id.produto")
	public Collection<VendaProduto> getVendaProdutoList() {
		return vendaProdutoList;
	}
	public void setVendaProdutoList(Collection<VendaProduto> vendaProdutoList) {
		this.vendaProdutoList = vendaProdutoList;
	}
	
	@Column(name="foto_produto")
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

}
