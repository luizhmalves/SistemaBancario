package br.com.sistemabancario.services;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemabancario.dao.AgenciasRepository;
import br.com.sistemabancario.dao.ContasRepository;
import br.com.sistemabancario.dao.LimitesRepository;
import br.com.sistemabancario.dao.PessoasRepository;
import br.com.sistemabancario.dto.DadosAberturaDto;
import br.com.sistemabancario.entidades.Conta;
import br.com.sistemabancario.entidades.Pessoa;

@Service
public class GeraPessoa {

	@Autowired
	private PessoasRepository pessoaRepository;

	@Autowired
	private ContasRepository contaRepository;

	@Autowired
	private AgenciasRepository agenciasRepository;

	@Autowired
	private LimitesRepository limitesRepository;

	public Pessoa geraPessoa(DadosAberturaDto abertura) throws Exception {
		SecureRandom random = new SecureRandom();
		if (abertura.getPessoa().getNumDoc().length() == 11) {
			Pessoa pessoa = new Pessoa();
			String cpfTemp = abertura.getPessoa().getNumDoc().replace(".", "").replace("-", "").replace("/", "");
			pessoa.setNome(abertura.getPessoa().getNome());
			pessoa.setTipo("PF");
			pessoa.setNumDoc(cpfTemp);
			pessoa.setScore(random.nextInt(9));
			pessoaRepository.save(pessoa);
			this.geraConta(pessoa, abertura.getIdAgencia());

			return pessoa;
			
		} else if (abertura.getPessoa().getNumDoc().length() == 14) {
			Pessoa pessoa = new Pessoa();
			String cnpjTemp = abertura.getPessoa().getNumDoc().replace(".", "").replace("-", "").replace("/", "");
			pessoa.setNome(abertura.getPessoa().getNome());
			pessoa.setTipo("PJ");
			pessoa.setScore(random.nextInt(9));
			pessoa.setNumDoc(cnpjTemp);
			pessoa.setScore(random.nextInt(9));
			pessoaRepository.save(pessoa);
			this.geraConta(pessoa, abertura.getIdAgencia());

			return pessoa;
		} else {
			throw new Exception("Cpf ou Cnpj inválido!");
		}
	}

	private void geraConta(Pessoa pessoa, Long idAgencia) {
		Random random = new Random(System.nanoTime());
		Conta conta = new Conta();
		conta.setPessoa(pessoa);
		conta.setAgencia(agenciasRepository.findById(idAgencia).get());
		conta.setLimite(limitesRepository.findByScore(pessoa.getScore()));
		conta.setNumConta(random.nextInt(999999));
		if (pessoa.getNumDoc().length() == 14) {
			conta.setTipo('E');
		} else if (pessoa.getNumDoc().length() == 11) {
			conta.setTipo('C');
		}
		contaRepository.save(conta);
	}
}
