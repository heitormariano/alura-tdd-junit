package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum DesempenhoInstrutor {
	A_DESEJAR {
		@Override
		public BigDecimal obterPercentualReajuste() {
			return new BigDecimal("0.03");
		}
	},
	BOM {
		@Override
		public BigDecimal obterPercentualReajuste() {
			return new BigDecimal("0.15");
		}
	},
	OTIMO {
		@Override
		public BigDecimal obterPercentualReajuste() {
			return new BigDecimal("0.2");
		}
	};

	public abstract BigDecimal obterPercentualReajuste();
}
