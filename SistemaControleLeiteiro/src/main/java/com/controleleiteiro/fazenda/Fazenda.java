package com.controleleiteiro.fazenda;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.PastOrPresent;

@Entity
public class Fazenda {

	private String nome;
	private float receitaTotal;
	private float despesaTotal;
	
	@PastOrPresent
	LocalDateTime criacao = LocalDateTime.now();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	public Fazenda() {
		
	}
	
	public Fazenda(String nome, float receitaTotal, float despesaTotal) {
		this.nome = nome;
		this.receitaTotal = receitaTotal;
		this.despesaTotal = despesaTotal;
	}


	@Override
	public String toString() {
		return "Fazenda [nome=" + nome + ", receitaTotal=" + receitaTotal + ", despesaTotal=" + despesaTotal
				+ ", criacao=" + criacao + ", id=" + id + "]";
	}

	public String getNome() {
		return nome;
	}

	public float getReceitaTotal() {
		return receitaTotal;
	}

	public float getDespesaTotal() {
		return despesaTotal;
	}

	public LocalDateTime getCriacao() {
		return criacao;
	}

	public long getId() {
		return id;
	}

	public void sumReceitaTotal(float receitaTotal) {
		this.receitaTotal += receitaTotal;
	}

	public void sumDespesaTotal(float despesaTotal) {
		this.despesaTotal += despesaTotal;
	}
	
	
	
	
	
	
	
	
}
