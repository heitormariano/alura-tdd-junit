package br.com.alura.tdd.servico;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.DesempenhoInstrutor;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceInstrutorTest {

	private ReajusteServiceInstrutor reajusteService;
	private Funcionario funcionario;

	@BeforeEach
	public void inicializar() {
		reajusteService = new ReajusteServiceInstrutor();
		funcionario = new Funcionario("Mark", LocalDate.now(), new BigDecimal("1000.00"));
	}

	@Test
	public void reajusteSalarioParaDesempenhoADesejar() {
		reajusteService.processarReajuste(funcionario, DesempenhoInstrutor.A_DESEJAR);

		BigDecimal salarioAtual = funcionario.getSalario();
		assertEquals(new BigDecimal("1030.00"), salarioAtual);
	}

	@Test
	public void reajusteSalarioParaDesempenhoBom() {
		reajusteService.processarReajuste(funcionario, DesempenhoInstrutor.BOM);

		BigDecimal salarioAtual = funcionario.getSalario();
		assertEquals(new BigDecimal("1150.00"), salarioAtual);
	}

	@Test
	public void reajusteSalarioParaDesempenhoOtimo() {
		reajusteService.processarReajuste(funcionario, DesempenhoInstrutor.OTIMO);

		BigDecimal salarioAtual = funcionario.getSalario();
		assertEquals(new BigDecimal("1200.00"), salarioAtual);
	}
}
