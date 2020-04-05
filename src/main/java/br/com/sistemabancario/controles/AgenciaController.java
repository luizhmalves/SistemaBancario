package br.com.sistemabancario.controles;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemabancario.dao.AgenciasRepository;
import br.com.sistemabancario.entidades.Agencia;

@RestController
public class AgenciaController {

	@Autowired
	private AgenciasRepository agenciasRepository;

	@PostMapping("/agencias")
	public void insereAgencia(@RequestBody @Valid Agencia agencia) {
		agenciasRepository.save(agencia);
	}

	@GetMapping("/agencias")
	public List<Agencia> todos() {
		return agenciasRepository.findAll();
	}
	
	@PutMapping("/agencias/{id}")
	public Agencia atualizaLimite(@PathVariable Long id, @RequestBody @Valid Agencia agencia) {
		Agencia agenciaCorrente = agenciasRepository.findById(id).get();
		if (agenciaCorrente != null) {
			agenciaCorrente.setDescricao(agencia.getDescricao());
			agenciaCorrente.setContas(agencia.getContas());
			agenciaCorrente.setNumAgencia(agencia.getNumAgencia());
		}
		
		return agenciasRepository.save(agenciaCorrente); 
	}
}
