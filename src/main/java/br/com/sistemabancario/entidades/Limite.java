package br.com.sistemabancario.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Limite implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Número de score obrigatório.")
	private Integer score;
	@NotNull(message = "Valor de limite para cheque especial obrigatório.")
	private Double limChequeEspecial;
	@NotNull(message = "Valor de limite para cartão de crédito obrigatório.")
	private Double limCartaoCredito;
	
	@JsonIgnore
	@OneToMany(mappedBy = "limite")
	private List<Conta> contas = new ArrayList<Conta>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Double getLimChequeEspecial() {
		return limChequeEspecial;
	}

	public void setLimChequeEspecial(Double limChequeEspecial) {
		this.limChequeEspecial = limChequeEspecial;
	}

	public Double getLimCartaoCredito() {
		return limCartaoCredito;
	}

	public void setLimCartaoCredito(Double limCartaoCredito) {
		this.limCartaoCredito = limCartaoCredito;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
}
