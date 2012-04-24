package br.ucb.beans;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nome;
	private String senha;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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

	//	public boolean equals (Object obj) {   
	//        if (obj == null) return false;   
	//        if (obj.getClass() != Usuario.class) return false;   
	//        Usuario outro = (Usuario) obj;   
	//        return nome.equals (outro.nome) && senha.equals (outro.senha);   
	//    }


}
