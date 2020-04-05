package br.com.sistemabancario.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Integer numConta;
	
	private Character tipo;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "agencia_conta")
	private Agencia agencia;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "pessoa_conta")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "limite_conta")
	private Limite limite;
	
	
	public Conta() {
		
//		this.setLimite(limitesDaoImpl.findById(Long.valueOf(this.getPessoa().getScore() + 1)).get());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumConta() {
		return numConta;
	}

	public void setNumConta(Integer numConta) {
		this.numConta = numConta;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Limite getLimite() {
		return limite;
	}

	public void setLimite(Limite limite) {
		this.limite = limite;
	}
	
	
	
	
}
