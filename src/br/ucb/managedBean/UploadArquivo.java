package br.ucb.managedBean;

import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.FileUploadEvent;

public class UploadArquivo {

	private String diretorio;
	private String caminho;
	private byte[] arquivo;
	private String nome;
	
	public UploadArquivo() {
	}

	public String getDiretorio() {
		return this.diretorio;
	}

	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getRealPath() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

		FacesContext aFacesContext = FacesContext.getCurrentInstance();
		ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();

		return context.getRealPath("/");
	}

	public void fileUpload(FileUploadEvent event, String diretorio) {
		try {
			this.nome = event.getFile().getFileName();
			this.caminho = getRealPath() + diretorio;
			this.arquivo = event.getFile().getContents();

			File file = new File(getRealPath() + diretorio);
			file.mkdirs();

		} catch (Exception ex) {
			System.out.println("Erro no upload do arquivo" + ex);
		}
	}

	public void gravar(String nome){

		try {

			FileOutputStream fos;
			fos = new FileOutputStream(this.caminho + nome);
			fos.write(this.arquivo);
			fos.close();

		} catch (Exception ex) {
			Logger.getLogger(UploadArquivo.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}

