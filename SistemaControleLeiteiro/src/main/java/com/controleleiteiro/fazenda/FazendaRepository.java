package com.controleleiteiro.fazenda;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FazendaRepository extends JpaRepository<Fazenda, Long>{
	
	public Optional<Fazenda> findByNome(String nome);
	
	public boolean existsByNome(String nome);
	
}
