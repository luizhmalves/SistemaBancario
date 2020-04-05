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

import br.com.sistemabancario.dao.LimitesRepository;
import br.com.sistemabancario.entidades.Limite;

@RestController
public class LimiteController {

	@Autowired
	private LimitesRepository limitesRepository;

	@PostMapping("/limites")
	public void insereLimite(@RequestBody @Valid Limite limite) {
		limitesRepository.save(limite);
	}

	@GetMapping("/limites")
	public List<Limite> todos() {
		return limitesRepository.findAll();
	}
	
	@PutMapping("/limites/{id}")
	public Limite atualizaLimite(@PathVariable Long id, @RequestBody @Valid Limite limite) {
		Limite limiteCorrente = limitesRepository.findById(id).get();
		if (limiteCorrente != null) {
			limiteCorrente.setScore(limite.getScore());
			limiteCorrente.setContas(limite.getContas());
			limiteCorrente.setLimCartaoCredito(limite.getLimCartaoCredito());
			limiteCorrente.setLimChequeEspecial(limite.getLimChequeEspecial());
		}
		
		return limitesRepository.save(limiteCorrente); 
	}
}
