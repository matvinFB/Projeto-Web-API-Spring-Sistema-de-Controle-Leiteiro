package com.controleleiteiro.fazenda;


import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Transactional
public class FazendaController {

	@Autowired
	FazendaRepository fazendaRepository;
	
	@PostMapping(value = "/fazenda")
	public ResponseEntity<Object> addFazenda(@RequestBody @Valid CadastraFazendaRequest cadastraFazendaRequest) {	
		
		boolean existeFazenda = fazendaRepository.existsByNome(cadastraFazendaRequest.getNome());
		
		if(existeFazenda) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro!");
		}
		
		Fazenda fazenda = cadastraFazendaRequest.toModel();
		
		fazendaRepository.save(fazenda);
		
		return ResponseEntity.status(HttpStatus.OK).body("Deu bom!");
	}
}
