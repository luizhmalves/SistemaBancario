package br.com.sistemabancario.controles;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemabancario.dao.PessoasRepository;
import br.com.sistemabancario.dto.DadosAberturaDto;
import br.com.sistemabancario.entidades.Pessoa;
import br.com.sistemabancario.services.GeraPessoa;

@RestController
public class PessoaController {
	
	@Autowired
	private GeraPessoa geraPessoa;
	
	@Autowired
	private PessoasRepository pessoasRepository;
	
	@PostMapping("/pessoas")
	public Pessoa novaPessoa(@RequestBody @Valid DadosAberturaDto novaPessoa) {
		return geraPessoa.geraPessoa(novaPessoa);
	}
	
	@GetMapping("/pessoas")
	public List<Pessoa> todasPessoas() {
		return pessoasRepository.findAll();
	}
}
