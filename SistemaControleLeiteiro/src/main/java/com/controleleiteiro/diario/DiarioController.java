package com.controleleiteiro.diario;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.controleleiteiro.fazenda.Fazenda;
import com.controleleiteiro.fazenda.FazendaRepository;


@RestController
@Transactional
public class DiarioController {
	
	@Autowired
	ReceitaRepository receitaRepository;
	@Autowired
	DespesaRepository despesaRepository;
	@Autowired
	LeiteProduzidoRepository leiteProduzidoRepository;
	
	@Autowired
	FazendaRepository fazendaRepository;
	
	@PostMapping(value = "/entradadiario/")
	public ResponseEntity<Object> addEntrada(@RequestBody @Valid CadastraDiarioRequest cadastraDiarioRequest) {	
			
			
			boolean existeFazenda = fazendaRepository.existsByNome(cadastraDiarioRequest.getNome());
			
			if(!existeFazenda) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro!");
			}
			
			Receita receita = cadastraDiarioRequest.toModelReceita();
			Despesa despesa = cadastraDiarioRequest.toModelDespesa();
			LeiteProduzido leiteProduzido = cadastraDiarioRequest.toModelLeiteProduzido();
			
			receitaRepository.save(receita);
			despesaRepository.save(despesa);
			leiteProduzidoRepository.save(leiteProduzido);
			
			Optional<Fazenda> fazendaTemp = fazendaRepository.findByNome(cadastraDiarioRequest.getNome());
			Fazenda fazenda = fazendaTemp.get();
			fazenda.sumDespesaTotal(despesa.sumAll());
			fazenda.sumReceitaTotal(receita.sumAll());
			fazendaRepository.save(fazenda);
			
			
			//LEMBRAR DE SOMAR TUDO E SOMAR AS DESPESAS E LUCROS DA FAZENDA
			
			return ResponseEntity.status(HttpStatus.OK).body("Deu bom!");
		}
}
