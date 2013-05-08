package br.com.heron.divisordespesas.grupo.calculadora;

import java.util.List;

import br.com.heron.divisordespesas.configuracao.Categoria;
import br.com.heron.divisordespesas.grupo.Participante;

public class Calculadora {
	
	private CalculadoraGastos calculadoraGastos;
	private CalculadoraContribuicao calculadoraContribuicao;
	
	public Calculadora(List<Participante> participantes){
		calculadoraGastos = new CalculadoraGastos(participantes);
		calculadoraContribuicao = new CalculadoraContribuicao(participantes);
	}
	
	public List<Categoria> consumos() {
		return calculadoraGastos.consumos();
	}

	public List<Participante> consumidores(Categoria categoria) {
		return calculadoraGastos.consumidores(categoria);
	}
	
	public double contribuicaoTotal() {
		return calculadoraContribuicao.contribuicaoTotal();
	}
	
	public double contribuicao(Categoria categoria) {
		return calculadoraContribuicao.contribuicao(categoria);
	}
	
	public double valorFinal(Categoria categoria) {
		double valorGasto = gastos(categoria);
		double quantidadeConsumidores = consumidores(categoria).size();
		return valorGasto/quantidadeConsumidores;
	}
	
	public double valorFinal(Participante participante) {
		double valorParticipante = 0;
		for (Categoria categoria : participante.consumo().categorias()) {
			valorParticipante += valorFinal(categoria);
		}
		
		return roundUp(valorParticipante);
	}
	
	public double valorParaReceber(Participante participante) {
		double valorContribuido = participante.valorContribuido();
		double valorFinal = valorFinal(participante);
		
		if(valorContribuido < valorFinal)
			return 0.0;
		
		double valorTotal = valorContribuido - valorFinal;
		return roundUp(valorTotal);
	}
	
	public double valorParaPagar(Participante participante) {
		double valorContribuido = participante.valorContribuido();
		double valorFinal = valorFinal(participante);
		
		if(valorFinal < valorContribuido)
			return 0.0;
		
		double valorTotal =  (valorFinal - valorContribuido);
		return roundUp(valorTotal);
	}
	
	private double gastos(Categoria categoria) {
		return calculadoraContribuicao.contribuicao(categoria);
	}

	private static double roundUp(double valorTotal) {
		return (double) Math.round(valorTotal * 100) / 100;
	}
	
}
