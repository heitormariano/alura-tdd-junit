package br.com.alura.tdd.servico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.exception.SalarioSemDireitoABonusException;
import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void calculoBonusSalarioAcimaDoLimite() throws SalarioSemDireitoABonusException {
		BonusService service = new BonusService();
		Funcionario func = new Funcionario("Hector", LocalDate.now(), new BigDecimal("25000.10"));
		assertThrows(SalarioSemDireitoABonusException.class, () -> service.calcularBonus(func));
	}
	
	
	@Test
	void calculoBonusSalarioIgualAoLimite() throws SalarioSemDireitoABonusException {
		BonusService service = new BonusService();
		Funcionario func = new Funcionario("Hector", LocalDate.now(), new BigDecimal("10000.00"));
		assertEquals(new BigDecimal("1000.00"), service.calcularBonus(func));
	}
	
	
	@Test
	void calculoBonusSalarioAbaixoDoLimite() throws SalarioSemDireitoABonusException {
		BonusService service = new BonusService();
		Funcionario func = new Funcionario("Hector", LocalDate.now(), new BigDecimal("8000.00"));
		assertEquals(new BigDecimal("800.00"), service.calcularBonus(func));
	}

}
