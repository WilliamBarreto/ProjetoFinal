package br.ucb.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="autorizacao")
public class Autorizacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int usuario;
	private String papel;
	
	@Id
	@Column(name="usuario")
	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	@Column(name="papel")
	public String getPapel() {
		return papel;
	}
	public void setPapel(String papel) {
		this.papel = papel;
	}
	
	
	
}
