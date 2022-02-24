package br.com.alura.tdd.servico;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	@Test
	public void reajusteSalarioParaDesempenhoADesejar() {
		ReajusteService reajusteService = new ReajusteService();
		Funcionario funcionario = new Funcionario("Mark", LocalDate.now(), new BigDecimal("1000.00"));

		reajusteService.processarReajuste(funcionario, Desempenho.A_DESEJAR);

		BigDecimal salarioAtual = funcionario.getSalario();
		assertEquals(new BigDecimal("1030.00"), salarioAtual);
	}

	@Test
	public void reajusteSalarioParaDesempenhoBom() {
		ReajusteService reajusteService = new ReajusteService();
		Funcionario funcionario = new Funcionario("John", LocalDate.now(), new BigDecimal("1000.00"));

		reajusteService.processarReajuste(funcionario, Desempenho.BOM);

		BigDecimal salarioAtual = funcionario.getSalario();
		assertEquals(new BigDecimal("1150.00"), salarioAtual);
	}

	@Test
	public void reajusteSalarioParaDesempenhoOtimo() {
		ReajusteService reajusteService = new ReajusteService();
		Funcionario funcionario = new Funcionario("Karen", LocalDate.now(), new BigDecimal("1000.00"));

		reajusteService.processarReajuste(funcionario, Desempenho.OTIMO);

		BigDecimal salarioAtual = funcionario.getSalario();
		assertEquals(new BigDecimal("1200.00"), salarioAtual);
	}
}
