package br.com.sistemabancario.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemabancario.dao.ContasRepository;
import br.com.sistemabancario.entidades.Conta;

@RestController
public class ContaController {

	@Autowired
	private ContasRepository contasRepository;

	/*
	 * @PostMapping("/contas") public void insereLimite(@RequestBody Conta conta) {
	 * contasRepository.save(conta); }
	 */

	@GetMapping("/contas")
	public List<Conta> todos() {
		return contasRepository.findAll();
	}
}
