package com.controleleiteiro.diario;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.controleleiteiro.fazenda.Fazenda;
import com.controleleiteiro.fazenda.FazendaRepository;
import com.sun.istack.NotNull;

public class CadastraDiarioRequest {
	
	@NotBlank
	@Size(max=150)
	String nome;
	@NotNull
	long Id;
	
	//Receita
	float leiteVendido=0;
	float animaisVendidos=0;
	float outrasReceitas=0;
	
	//Despesa
	float eletricidade=0;
	float alimentacaoAnimais=0;
	float maoDeObra=0;
	float combustivel=0;
	float medicamento=0;
	float outrasDespesas=0;
	
	//Produção de Leite
	@NotNull
	int vacasEmLactacao=0;
	@NotNull
	float leiteProduzido=0;
	float leiteBezerro=0;
	float leiteFazenda=0;
	float leiteFuncionarios=0;
	float leiteOutros=0;
	@NotNull
	float leiteVendidoLitros=0;
	
	@PastOrPresent
	LocalDateTime data = LocalDateTime.now();
	
	@Autowired
	FazendaRepository fazendaRepo;
	
	public CadastraDiarioRequest() {
		
	}

	public CadastraDiarioRequest(@NotBlank @Size(max = 150) String nome, float leiteVendido,
			float animaisVendidos, float outrasReceitas, float eletricidade, float alimentacaoAnimais, float maoDeObra,
			float combustivel, float medicamento, float outrasDespesas, @NotBlank int vacasEmLactacao,
			@NotBlank float leiteProduzido, float leiteBezerro, float leiteFazenda, float leiteFuncionarios,
			float leiteOutros, @NotBlank float leiteVendidoLitros) {
		super();
		this.nome = nome;
		Optional<Fazenda> fazendaTemp = fazendaRepo.findByNome(nome);
		Fazenda fazenda = fazendaTemp.get();
		Id = fazenda.getId();
		this.leiteVendido = leiteVendido;
		this.animaisVendidos = animaisVendidos;
		this.outrasReceitas = outrasReceitas;
		this.eletricidade = eletricidade;
		this.alimentacaoAnimais = alimentacaoAnimais;
		this.maoDeObra = maoDeObra;
		this.combustivel = combustivel;
		this.medicamento = medicamento;
		this.outrasDespesas = outrasDespesas;
		this.vacasEmLactacao = vacasEmLactacao;
		this.leiteProduzido = leiteProduzido;
		this.leiteBezerro = leiteBezerro;
		this.leiteFazenda = leiteFazenda;
		this.leiteFuncionarios = leiteFuncionarios;
		this.leiteOutros = leiteOutros;
		this.leiteVendidoLitros = leiteVendidoLitros;
	}


	public Receita toModelReceita() {
		return new Receita(this.nome, this.data, this.leiteVendido, this.animaisVendidos, this.outrasReceitas);
	}
	
	public Despesa toModelDespesa() {
		return new Despesa(this.nome, this.data, this.eletricidade, this.alimentacaoAnimais, this.maoDeObra, this.combustivel, this.medicamento, this.outrasDespesas);
	}
	
	public LeiteProduzido toModelLeiteProduzido() {
		return new LeiteProduzido(this.nome, this.data, this.vacasEmLactacao, this.leiteProduzido, this.leiteBezerro, this.leiteFazenda, this.leiteFuncionarios, this.leiteOutros, this.leiteVendidoLitros);
	}


	public String getNome() {
		return nome;
	}


	public long getId() {
		return Id;
	}


	public float getLeiteVendido() {
		return leiteVendido;
	}


	public float getAnimaisVendidos() {
		return animaisVendidos;
	}


	public float getOutrasReceitas() {
		return outrasReceitas;
	}


	public float getEletricidade() {
		return eletricidade;
	}


	public float getAlimentacaoAnimais() {
		return alimentacaoAnimais;
	}


	public float getMaoDeObra() {
		return maoDeObra;
	}


	public float getCombustivel() {
		return combustivel;
	}


	public float getMedicamento() {
		return medicamento;
	}


	public float getOutrasDespesas() {
		return outrasDespesas;
	}


	public int getVacasEmLactacao() {
		return vacasEmLactacao;
	}


	public float getLeiteProduzido() {
		return leiteProduzido;
	}


	public float getLeiteBezerro() {
		return leiteBezerro;
	}


	public float getLeiteFazenda() {
		return leiteFazenda;
	}


	public float getLeiteFuncionarios() {
		return leiteFuncionarios;
	}


	public float getLeiteOutros() {
		return leiteOutros;
	}


	public float getLeiteVendidoLitros() {
		return leiteVendidoLitros;
	}


	public LocalDateTime getData() {
		return data;
	}


	public FazendaRepository getFazendaRepo() {
		return fazendaRepo;
	}
	
	
	
	
}
