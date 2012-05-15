package br.ucb.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;	
	private int id;
	private String nome;
	private String cpf;
	private String email;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String cep;
	private String uf;
	private UsuarioCliente usuario;
	/*private Date dataNasc;
	
	
	public Date getDataNasc() {
		return dataNasc;
	}


	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
*/

	public Cliente(){
		this.usuario = new UsuarioCliente();
	}
	
	
	@Id
	@GeneratedValue
	@Column(name="id_cliente")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="nome_cliente")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="cpf_cliente")
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name="email_cliente")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="logradouro_cliente")
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Column(name="bairro_cliente")
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	@Column(name="cidade_cliente")	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(name="cep_cliente")
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name="uf_cliente")
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}

	@OneToOne   
    @JoinColumn(name="usuarioc_id_usuario_cliente")   
	public UsuarioCliente getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioCliente usuario) {
		this.usuario = usuario;
	}		
	
	
}
