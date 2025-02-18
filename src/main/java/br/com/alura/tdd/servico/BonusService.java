package br.com.alura.tdd.servico;

import br.com.alura.tdd.exception.SalarioSemDireitoABonusException;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BonusService {

    private static final BigDecimal PERCENTUAL_BONUS = new BigDecimal("0.1");
    private static final BigDecimal LIMITE_SALARIAL = new BigDecimal("10000");

    public BigDecimal calcularBonus(Funcionario funcionario) throws SalarioSemDireitoABonusException {
        if (funcionario.getSalario().compareTo(LIMITE_SALARIAL) > 0) {
            throw new SalarioSemDireitoABonusException("Salario acima de R$ 10.000,00. Sem direito a bonus");
        }

        BigDecimal bonusCalculado = funcionario.getSalario().multiply(PERCENTUAL_BONUS);
        return bonusCalculado.setScale(2, RoundingMode.HALF_UP);
    }
}
