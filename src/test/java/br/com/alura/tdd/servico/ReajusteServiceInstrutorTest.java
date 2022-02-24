package br.com.alura.tdd.servico;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.DesempenhoInstrutor;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceInstrutorTest {

	@Test
	public void reajusteSalarioParaDesempenhoADesejar() {
		ReajusteServiceInstrutor reajusteService = new ReajusteServiceInstrutor();
		Funcionario funcionario = new Funcionario("Mark", LocalDate.now(), new BigDecimal("1000.00"));

		reajusteService.processarReajuste(funcionario, DesempenhoInstrutor.A_DESEJAR);

		BigDecimal salarioAtual = funcionario.getSalario();
		assertEquals(new BigDecimal("1030.00"), salarioAtual);
	}

	@Test
	public void reajusteSalarioParaDesempenhoBom() {
		ReajusteServiceInstrutor reajusteService = new ReajusteServiceInstrutor();
		Funcionario funcionario = new Funcionario("John", LocalDate.now(), new BigDecimal("1000.00"));

		reajusteService.processarReajuste(funcionario, DesempenhoInstrutor.BOM);

		BigDecimal salarioAtual = funcionario.getSalario();
		assertEquals(new BigDecimal("1150.00"), salarioAtual);
	}

	@Test
	public void reajusteSalarioParaDesempenhoOtimo() {
		ReajusteServiceInstrutor reajusteService = new ReajusteServiceInstrutor();
		Funcionario funcionario = new Funcionario("Karen", LocalDate.now(), new BigDecimal("1000.00"));

		reajusteService.processarReajuste(funcionario, DesempenhoInstrutor.OTIMO);

		BigDecimal salarioAtual = funcionario.getSalario();
		assertEquals(new BigDecimal("1200.00"), salarioAtual);
	}
}
