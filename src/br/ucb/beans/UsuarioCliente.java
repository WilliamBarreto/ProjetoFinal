package br.ucb.beans;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType; 




@Entity
@Table(name="usuarioc")
public class UsuarioCliente extends Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private Cliente cliente;
	
	@Id
	@GeneratedValue
	@Column(name="id_usuario_cliente")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="nome_usuario_cliente")
	public String getNome(){
		return super.getNome();
	}
	
	@Column(name="senha_usurio_cliente") 
	public String getSenha(){
		return super.getSenha();
	}
	
	
	@OneToOne(mappedBy="usuario")
	@Cascade(CascadeType.ALL)
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
}
