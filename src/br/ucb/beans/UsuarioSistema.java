package br.ucb.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class UsuarioSistema extends Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	@Id
	@GeneratedValue
	@Column(name="id_usuario_sistema")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="nome_usuario_sistema")
	public String getNome(){
		return super.getNome();
	}
	
	@Column(name="senha_usuario_sistema")
	public String getSenha(){
		return super.getSenha();
	}
	
}
