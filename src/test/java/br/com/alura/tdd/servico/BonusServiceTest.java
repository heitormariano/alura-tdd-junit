package br.com.alura.tdd.servico;

import br.com.alura.tdd.exception.SalarioSemDireitoABonusException;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusServiceTest {

    private BonusService bonusService;

    @BeforeEach
    public void inicializar() {
        bonusService = new BonusService();
    }

    @Test
    void calculoBonusSalarioAcimaDoLimite() throws SalarioSemDireitoABonusException {
        Funcionario func = new Funcionario("Hector", LocalDate.now(), new BigDecimal("25000.10"));
        assertThrows(SalarioSemDireitoABonusException.class, () -> bonusService.calcularBonus(func));
    }

    @Test
    void calculoBonusSalarioIgualAoLimite() throws SalarioSemDireitoABonusException {
        Funcionario func = new Funcionario("Hector", LocalDate.now(), new BigDecimal("10000.00"));
        assertEquals(new BigDecimal("1000.00"), bonusService.calcularBonus(func));
    }

    @Test
    void calculoBonusSalarioAbaixoDoLimite() throws SalarioSemDireitoABonusException {
        Funcionario func = new Funcionario("Hector", LocalDate.now(), new BigDecimal("8000.00"));
        assertEquals(new BigDecimal("800.00"), bonusService.calcularBonus(func));
    }
}
