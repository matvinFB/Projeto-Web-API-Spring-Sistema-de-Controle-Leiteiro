package com.controleleiteiro.diario;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LeiteProduzido {
	private String nome;
	@Id
	private LocalDateTime data;
	private int vacasEmLactacao;
	private float leiteProduzido;
	private float leiteBezerro;
	private float leiteFazenda;
	private float leiteFuncionarios;
	private float leiteOutros;
	private float leiteVendidoLitros;
	
	public LeiteProduzido() {
		
	}
	public LeiteProduzido(String nome, LocalDateTime data, int vacasEmLactacao, float leiteProduzido,
			float leiteBezerro, float leiteFazenda, float leiteFuncionarios, float leiteOutros,
			float leiteVendidoLitros) {
		this.nome = nome;
		this.data = data;
		this.vacasEmLactacao = vacasEmLactacao;
		this.leiteProduzido = leiteProduzido;
		this.leiteBezerro = leiteBezerro;
		this.leiteFazenda = leiteFazenda;
		this.leiteFuncionarios = leiteFuncionarios;
		this.leiteOutros = leiteOutros;
		this.leiteVendidoLitros = leiteVendidoLitros;
	}

	@Override
	public String toString() {
		return "LeiteProduzido [nome=" + nome + ", data=" + data + ", vacasEmLactacao=" + vacasEmLactacao
				+ ", leiteProduzido=" + leiteProduzido + ", leiteBezerro=" + leiteBezerro + ", leiteFazenda="
				+ leiteFazenda + ", leiteFuncionarios=" + leiteFuncionarios + ", leiteOutros=" + leiteOutros
				+ ", leiteVendidoLitros=" + leiteVendidoLitros + "]";
	}
	
	
	
	
}
