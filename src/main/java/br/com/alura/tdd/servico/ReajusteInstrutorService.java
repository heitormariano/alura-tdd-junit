package br.com.alura.tdd.servico;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.DesempenhoInstrutor;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceInstrutor {

	public void processarReajuste(Funcionario funcionario, DesempenhoInstrutor desempenho) {
		BigDecimal salarioFunc = funcionario.getSalario();
		BigDecimal percentualReajuste = desempenho.obterPercentualReajuste();
		BigDecimal reajuste = salarioFunc.multiply(percentualReajuste);

		funcionario.reajustarSalario(reajuste);
	}

}
