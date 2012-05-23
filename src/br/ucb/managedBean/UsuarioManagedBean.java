package br.ucb.managedBean;

import br.ucb.beans.Cliente;
import br.ucb.beans.Produto;
import br.ucb.beans.Usuario;
import br.ucb.beans.Venda;
import br.ucb.beans.VendaProduto;
import br.ucb.beans.VendaProduto.VendaProdutofk;
import br.ucb.persistencia.ClienteHIB;
import br.ucb.persistencia.ProdutoHIB;
import br.ucb.persistencia.UsuarioHIB;
import br.ucb.persistencia.VendaHIB;
import br.ucb.persistencia.VendaProdutoHIB;


public class UsuarioManagedBean {
	private Usuario usuario;
	private Cliente cliente;
	private Venda venda;
	private Produto produto;
	private VendaProduto vendaProduto;
	private VendaProdutofk vendaProdutofk;	
	
	public UsuarioManagedBean(){
		this.usuario = new Usuario();
		this.cliente = new Cliente();
		this.venda = new Venda();
		this.produto = new Produto();
		this.vendaProduto = new VendaProduto();
		this.vendaProdutofk = this.vendaProduto.new VendaProdutofk();
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public VendaProduto getVendaProduto() {
		return vendaProduto;
	}

	public void setVendaProduto(VendaProduto vendaProduto) {
		this.vendaProduto = vendaProduto;
	}

	public VendaProdutofk getVendaProdutofk() {
		return vendaProdutofk;
	}

	public void setVendaProdutofk(VendaProdutofk vendaProdutofk) {
		this.vendaProdutofk = vendaProdutofk;
	}

	public String addTabela(){
		
		this.usuario.setLogin("will");
		new UsuarioHIB().salvar(this.usuario);
		
		this.cliente.setNome("William");
		this.cliente.setUsuario(usuario);
		
		new ClienteHIB().salvar(this.cliente);
		
		
		
		this.venda.setCliente(this.cliente);
		
		new VendaHIB().salvar(this.venda);
		
		this.produto.setNome("Arroz");
		this.produto.setPreco(10.0);
		
		new ProdutoHIB().salvar(this.produto);
		
		this.vendaProdutofk.setVenda(venda);
		this.vendaProdutofk.setProduto(produto);
		
		this.vendaProduto.setId(vendaProdutofk);
		this.vendaProduto.setPreco(this.produto.getPreco());
		this.vendaProduto.setQuantidade(5);
		
		new VendaProdutoHIB().salvar(vendaProduto);
		
		
		return "index";
	}
	
	
}
