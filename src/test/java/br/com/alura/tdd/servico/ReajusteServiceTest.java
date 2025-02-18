package br.com.alura.tdd.servico;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

    private ReajusteService reajusteService;

    @BeforeEach
    void inicializar() {
        reajusteService = new ReajusteService();
    }

    @Test
    public void reajusteSalarioParaDesempenhoModerado() {
        Funcionario funcionario = new Funcionario("Mark", LocalDate.now(), new BigDecimal("1000.00"));
        reajusteService.processarReajuste(funcionario, Desempenho.MEDIANO);

        BigDecimal salarioAtual = funcionario.getSalario();
        assertEquals(new BigDecimal("1030.00"), salarioAtual);
    }

    @Test
    public void reajusteSalarioParaDesempenhoBom() {
        Funcionario funcionario = new Funcionario("John", LocalDate.now(), new BigDecimal("1000.00"));
        reajusteService.processarReajuste(funcionario, Desempenho.BOM);

        BigDecimal salarioAtual = funcionario.getSalario();
        assertEquals(new BigDecimal("1150.00"), salarioAtual);
    }

    @Test
    public void reajusteSalarioParaDesempenhoOtimo() {
        Funcionario funcionario = new Funcionario("Karen", LocalDate.now(), new BigDecimal("1000.00"));
        reajusteService.processarReajuste(funcionario, Desempenho.OTIMO);

        BigDecimal salarioAtual = funcionario.getSalario();
        assertEquals(new BigDecimal("1200.00"), salarioAtual);
    }
}
