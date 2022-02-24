package br.com.alura.tdd.servico;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.exception.SalarioSemDireitoABonusException;
import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {
	public BigDecimal calcularBonus(Funcionario funcionario) throws SalarioSemDireitoABonusException {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new SalarioSemDireitoABonusException("Salario acima de R$ 10.000,00. Sem direito a bonus");
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}
}
