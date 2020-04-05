package br.com.sistemabancario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.sistemabancario.dao.AgenciasRepository;
import br.com.sistemabancario.dao.LimitesRepository;
import br.com.sistemabancario.entidades.Agencia;
import br.com.sistemabancario.entidades.Conta;
import br.com.sistemabancario.entidades.Limite;
import br.com.sistemabancario.entidades.Pessoa;

@SpringBootTest
class SistemaBancarioApplicationTests {
	
	@Autowired
	private LimitesRepository limitesDaoImpl;
	
	@Autowired
	private AgenciasRepository agenciasDaoImpl;
	
	@Test void contextLoads() { }
	 
	
	/*
	 * @Test void testaScorePessoa() { Pessoa pessoa = new Pessoa(); Boolean
	 * assertiva = false; if (pessoa.getScore() <= 9) { assertiva = true; }
	 * System.out.println(pessoa.getScore()); assertEquals(true, assertiva,
	 * "Score gerou no intervalo de 0 a 9"); }
	 * 
	 * @Test void insereAgencia() { Agencia agencia = new Agencia();
	 * agencia.setNumAgencia("001"); agencia.setDescricao("Banco teste");
	 * agenciasDaoImpl.save(agencia); }
	 */
	@Test
	void insereLimites() {
		
		Integer indice = 0;
		Limite limites = new Limite();
		limites.setScore(indice);
		limites.setLimChequeEspecial(0D);
		limites.setLimCartaoCredito(0D);
		limitesDaoImpl.save(limites);
		/*
		 * assertEquals(limitesDaoImpl.findByScore(indice).getLimChequeEspecial(),0D);
		 * assertEquals(limitesDaoImpl.findByScore(indice).getLimCartaoCredito(),0D);
		 */
		// Indice colocado até 10 para verificar a assertiva nula
		/*
		 * while (indice <= 10) {
		 * 
		 * if (indice <= 1) { Limite limites = new Limite(); limites.setId(indice);
		 * limites.setLimChequeEspecial(0D); limites.setLimCartaoCredito(0D);
		 * limitesDaoImpl.save(limites);
		 * 
		 * } else if (indice > 1 && indice < 6) { Limite limites = new Limite();
		 * limites.setId(indice); limites.setLimChequeEspecial(1000.00D);
		 * limites.setLimCartaoCredito(200.00D); limitesDaoImpl.save(limites);
		 * 
		 * } else if (indice > 6 && indice < 9) { Limite limites = new Limite();
		 * limites.setId(indice); limitesDaoImpl.save(limites);
		 * limites.setLimChequeEspecial(2000.00D);
		 * limites.setLimCartaoCredito(2000.00D); } else if (indice == 9) { Limite
		 * limites = new Limite(); limites.setId(indice);
		 * limites.setLimChequeEspecial(5000.00D);
		 * limites.setLimCartaoCredito(15000.00D); } else { Limite limites = new
		 * Limite(); } indice++; }
		 */
		
		/*
		 * for (int i = 0; i < 11; i++) { if (i <= 1) {
		 * assertEquals(limitesDaoImpl.findById(indice).get().getLimChequeEspecial(),0D)
		 * ;
		 * assertEquals(limitesDaoImpl.findById(indice).get().getLimCartaoCredito(),0D);
		 * } else if (i > 1 && i < 6) {
		 * assertEquals(limitesDaoImpl.findById(indice).get().getLimChequeEspecial(),
		 * 1000.00D);
		 * assertEquals(limitesDaoImpl.findById(indice).get().getLimCartaoCredito(),200.
		 * 00D); } else if (i > 6 && i < 9) {
		 * assertEquals(limitesDaoImpl.findById(indice).get().getLimChequeEspecial(),
		 * 2000.00D);
		 * assertEquals(limitesDaoImpl.findById(indice).get().getLimCartaoCredito(),2000
		 * .00D); } else if (i == 9) {
		 * assertEquals(limitesDaoImpl.findById(indice).get().getLimChequeEspecial(),
		 * 5000.00D);
		 * assertEquals(limitesDaoImpl.findById(indice).get().getLimCartaoCredito(),
		 * 15000.00D); } else {
		 * assertEquals(limitesDaoImpl.findById(indice).get().getLimChequeEspecial(),
		 * null);
		 * assertEquals(limitesDaoImpl.findById(indice).get().getLimCartaoCredito(),null
		 * ); }
		 * 
		 * }
		 */
	}

}
