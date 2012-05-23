package br.ucb.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="autorizacao")
public class Autorizacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String login;
	private String papel;
	
	@Id
	@Column(name="login")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	@Column(name="papel")
	public String getPapel() {
		return papel;
	}
	
	public void setPapel(String papel) {
		this.papel = papel;
	}
	
	
	
}
