package br.com.sistemabancario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemabancario.entidades.Conta;

@Repository
public interface ContasRepository extends JpaRepository<Conta, Long> {

}
