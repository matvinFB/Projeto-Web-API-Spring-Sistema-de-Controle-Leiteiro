package com.controleleiteiro.fazenda;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastraFazendaRequest {
	
	@NotBlank
	@Size(max = 150)
	String nome;
	float receitaTotal = 0;
	float despesaTotal = 0;
	
	public CadastraFazendaRequest(@NotBlank @Size(max = 150) String nome, float receitaTotal, float despesaTotal) {
		super();
		this.nome = nome;
		this.receitaTotal = receitaTotal;
		this.despesaTotal = despesaTotal;
	}

	public String getNome() {
		return nome;
	}

	public float getReceitaTotal() {
		return receitaTotal;
	}

	public void setReceitaTotal(float receitaTotal) {
		this.receitaTotal = receitaTotal;
	}

	public float getDespesaTotal() {
		return despesaTotal;
	}

	public void setDespesaTotal(float despesaTotal) {
		this.despesaTotal = despesaTotal;
	}

	@Override
	public String toString() {
		return "CadastraFazendaRequest [nome=" + nome + ", receitaTotal=" + receitaTotal + ", despesaTotal="
				+ despesaTotal + "]";
	}

	public Fazenda toModel() {
		return new Fazenda(this.nome, this.receitaTotal, this.despesaTotal);
	}
	
	
	
	
	
	
}
