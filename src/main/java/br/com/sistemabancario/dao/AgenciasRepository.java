package br.com.sistemabancario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemabancario.entidades.Agencia;

@Repository
public interface AgenciasRepository extends JpaRepository<Agencia, Long> {
	
}
