package br.com.sistemabancario.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.sistemabancario.annotation.CpfCnpj;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Nome não pode ser nulo.")
	@NotBlank(message = "Nome é obrigatório.")
	@NotEmpty(message = "Nome não pode estar em branco.")
	private String nome;
	@NotNull(message = "Número de documento inválido.")
	@NotBlank(message = "Número de documento é obrigatório.")
	@NotEmpty(message = "Número de documento não pode estar em branco.")
	@CpfCnpj(message = "Número de documento inválido.")
	private String numDoc;

	private Integer score;

	private String tipo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pessoa")
	private List<Conta> contas = new ArrayList<Conta>();

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}
