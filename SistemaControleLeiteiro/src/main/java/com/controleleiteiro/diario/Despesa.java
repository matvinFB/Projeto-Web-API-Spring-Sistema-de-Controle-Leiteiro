package com.controleleiteiro.diario;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Despesa {
	private String nome;
	@Id
	private LocalDateTime data;
	private float eletricidade;
	private float alimentacaoAnimais;
	private float maoDeObra;
	private float combustivel;
	private float medicamento;
	private float outrasDespesas;
	
	
	public Despesa() {
		
	}
	
	public Despesa(String nome, LocalDateTime data, float eletricidade, float alimentacaoAnimais, float maoDeObra,
			float combustivel, float medicamento, float outrasDespesas) {
		
		this.nome = nome;
		this.data = data;
		this.eletricidade = eletricidade;
		this.alimentacaoAnimais = alimentacaoAnimais;
		this.maoDeObra = maoDeObra;
		this.combustivel = combustivel;
		this.medicamento = medicamento;
		this.outrasDespesas = outrasDespesas;
	}

	@Override
	public String toString() {
		return "Despesa [nome=" + nome + ", data=" + data + ", eletricidade=" + eletricidade + ", alimentacaoAnimais="
				+ alimentacaoAnimais + ", maoDeObra=" + maoDeObra + ", combustivel=" + combustivel + ", medicamento="
				+ medicamento + ", outrasDespesas=" + outrasDespesas + "]";
	}
	
	public float sumAll() {
		return (this.eletricidade+this.alimentacaoAnimais+this.maoDeObra+this.combustivel+this.medicamento+this.outrasDespesas);
	}
	
	
	
}
