package br.com.sistemabancario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemabancario.entidades.Limite;

@Repository
public interface LimitesRepository extends JpaRepository<Limite, Long>{
	public Limite findByScore(Integer score);
}
