package br.com.sistemabancario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemabancario.entidades.Pessoa;
@Repository
public interface PessoasRepository extends JpaRepository<Pessoa, Long> {

}
