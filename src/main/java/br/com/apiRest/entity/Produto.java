package br.com.apiRest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Produto {
	
	@Id
    @GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	@ManyToOne
	@JoinColumn(name="categoria_id")	
	private Categoria categoria;
	private String produto;
	private double preco;
	private int quantidade;
	private String descricao;
	private byte foto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public byte getFoto() {
		return foto;
	}
	public void setFoto(byte foto) {
		this.foto = foto;
	}
	
	
	
	

}
