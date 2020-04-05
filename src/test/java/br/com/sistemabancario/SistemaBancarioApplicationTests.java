package br.com.sistemabancario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.sistemabancario.dao.AgenciasRepository;
import br.com.sistemabancario.dao.LimitesRepository;
import br.com.sistemabancario.entidades.Agencia;
import br.com.sistemabancario.entidades.Limite;

@SpringBootTest
class SistemaBancarioApplicationTests {

	@Autowired
	private LimitesRepository limitesDaoImpl;

	@Autowired
	private AgenciasRepository agenciasDaoImpl;

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

}
