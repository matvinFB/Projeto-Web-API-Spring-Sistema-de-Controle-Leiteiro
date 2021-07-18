package com.controleleiteiro.diario;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Receita {
	private String nome;
	@Id
	private LocalDateTime data;
	private float leiteVendido;
	private float animaisVendidos;
	private float outrasReceitas;
	
	
	public Receita() {
		
	}
	
	public Receita(String nome, LocalDateTime data, float leiteVendido, float animaisVendidos, float outrasReceitas) {
		this.nome = nome;
		this.data = data;
		this.leiteVendido = leiteVendido;
		this.animaisVendidos = animaisVendidos;
		this.outrasReceitas = outrasReceitas;
	}

	public String toString() {
		return "Receita [nome=" + nome + ", data=" + data + ", leiteVendido=" + leiteVendido + ", animaisVendidos="
				+ animaisVendidos + ", outros=" + outrasReceitas + "]";
	}
	
	public float sumAll() {
		return (this.leiteVendido+this.animaisVendidos+this.outrasReceitas);
	}
	
	
	
	
}
