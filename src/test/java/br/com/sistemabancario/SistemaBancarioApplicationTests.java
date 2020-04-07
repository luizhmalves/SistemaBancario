package br.com.sistemabancario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.sistemabancario.dao.AgenciasRepository;
import br.com.sistemabancario.dao.LimitesRepository;
import br.com.sistemabancario.entidades.Agencia;
import br.com.sistemabancario.entidades.Limite;
import br.com.sistemabancario.validator.CpfCnpjValidator;

@SpringBootTest
class SistemaBancarioApplicationTests {

	@Autowired
	private LimitesRepository limitesDaoImpl;

	@Autowired
	private AgenciasRepository agenciasDaoImpl;
	
//	@Autowired
//	private CpfCnpjValidator cpfCnpj;
	private CpfCnpjValidator cpfCnpj = new CpfCnpjValidator();
	@Test
	void contextLoads() {
	}

	@Test
	void insereAgencia() {
		Agencia agencia = new Agencia();
		agencia.setNumAgencia("001");
		agencia.setDescricao("Banco teste");
		agenciasDaoImpl.save(agencia);
	}

	@Test
	void insereLimites() {

		Integer indice = 0;

		while (indice < 9) {

			if (indice <= 1) {
				Limite limites = new Limite();
				limites.setScore(indice);
				limites.setLimChequeEspecial(0D);
				limites.setLimCartaoCredito(0D);
				limitesDaoImpl.save(limites);

			} else if (indice > 1 && indice < 6) {
				Limite limites = new Limite();
				limites.setScore(indice);
				limites.setLimChequeEspecial(1000.00D);
				limites.setLimCartaoCredito(200.00D);
				limitesDaoImpl.save(limites);

			} else if (indice >= 6 && indice < 9) {
				Limite limites = new Limite();
				limites.setScore(indice);
				limites.setLimChequeEspecial(2000.00D);
				limites.setLimCartaoCredito(2000.00D);
				limitesDaoImpl.save(limites);
			} else if (indice == 9) {
				Limite limites = new Limite();
				limites.setScore(indice);
				limites.setLimChequeEspecial(5000.00D);
				limites.setLimCartaoCredito(15000.00D);
			}
			indice++;
		}

	}
	
	@Test
	void testaCpfInvalido() {
		assertEquals(false, cpfCnpj.isValid("111.111.111-11", null));
	}
	
	@Test
	void testaCpfNulo() {
		assertEquals(true, cpfCnpj.isValid(null, null));
	}
	
	@Test
	void testaCpfBranco() {
		assertEquals(true, cpfCnpj.isValid("", null));
	}
	
	@Test
	void testaCpfValido() {
		assertEquals(true, cpfCnpj.isValid("296.480.820-14", null));
	}
	
	@Test
	void testaCnpjInvalido() {
		assertEquals(false, cpfCnpj.isValid("99.999.999/9999-99", null));
	}
	
	@Test
	void testaCnpjNulo() {
		assertEquals(true, cpfCnpj.isValid(null, null));
	}
	
	@Test
	void testaCnpjBranco() {
		assertEquals(true, cpfCnpj.isValid("", null));
	}
	
	@Test
	void testaCnpjValido() {
		assertEquals(true, cpfCnpj.isValid("81.639.065/0001-83", null));
	}

}
