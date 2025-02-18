package br.com.alura.tdd.servico;

import br.com.alura.tdd.modelo.DesempenhoInstrutor;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteInstrutorService {

    public void processarReajuste(Funcionario funcionario, DesempenhoInstrutor desempenho) {
        BigDecimal reajuste = funcionario.getSalario().multiply(desempenho.obterPercentualReajuste());
        funcionario.reajustarSalario(reajuste);
    }
}
