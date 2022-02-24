package br.com.alura.tdd.servico;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void processarReajuste(Funcionario funcionario, Desempenho desempenho) {
		BigDecimal salarioFunc = funcionario.getSalario();
		BigDecimal reajuste = new BigDecimal("0.00");

		switch (desempenho) {
		case A_DESEJAR:
			reajuste = salarioFunc.multiply(new BigDecimal("0.03"));
			break;

		case BOM:
			reajuste = salarioFunc.multiply(new BigDecimal("0.15"));
			break;

		case OTIMO:
			reajuste = salarioFunc.multiply(new BigDecimal("0.20"));
			break;

		default:
			System.out.println("Tipo de Desempenho inválido");
			break;
		}

		funcionario.reajustarSalario(reajuste);

	}

}
