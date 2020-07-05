package br.com.apiRest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Pedido {
	
	@Id
    @GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	private String data;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	private int status;
	private String sessao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSessao() {
		return sessao;
	}
	public void setSessao(String sessao) {
		this.sessao = sessao;
	}
}