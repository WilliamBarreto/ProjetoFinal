package br.ucb.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	private String login;
	private String senha;
	private Autorizacao autorizacao;
	
	
	@Id
	@Column(name="login")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Column(name="senha")
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@OneToOne
	@JoinColumn(name="login")
	public Autorizacao getAutorizacao() {
		return autorizacao;
	}
	public void setAutorizacao(Autorizacao autorizacao) {
		this.autorizacao = autorizacao;
	}
	public static String geraSenha(){

		String[] carct ={"0","1","2","3","4","5","6","7","8","9",
				"a","b","c","d","e","f","g","h","i","j",
				"k","l","m","n","o","p","q","r","s","t","u",
				"v","w","x","y","z","A","B","C","D","E","F",
				"G","H","I","J","K","L","M","N","O","P","Q",
				"R","S","T","U","V","W","X","Y","Z"}; 

		String senha=""; 

		for (int x=0; x<10; x++){ 
			int j = (int) (Math.random()*carct.length); 
			senha += carct[j]; 

		} 
		return senha;
	}


}
