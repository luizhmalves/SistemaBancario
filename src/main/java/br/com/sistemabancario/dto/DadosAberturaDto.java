package br.com.sistemabancario.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.sistemabancario.entidades.Pessoa;

public class DadosAberturaDto {
	@NotNull(message = "Necessário informar nome e/ou número de documento válidos.")
	@Valid
	public Pessoa pessoa;
	@NotNull(message = "Necessário informar uma agência válida.")
	public Long idAgencia;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Long getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}
	
	
	
}
