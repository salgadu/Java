public class Posto {
	public float[] tanques = new float[3];
	public float[] litrosVendidos = new float[4];
	public float[] litrosComprados = new float[4];
	public float despesaCombustiveis;
	public float lucroCombustiveis;

	public Posto() {
		for (int i = 0; i < 3; i++) {
			this.tanques[i] = 0;
		}
	}

	public void abastecerTanque(int tanque, int valor) {
		if (tanque == 1) {

			if ((this.tanques[0] + valor) <= 200 && (valor > 0)) {
				this.tanques[0] += valor;
				this.litrosComprados[0] += valor;
				this.litrosComprados[3] += valor;
				this.despesaCombustiveis += ((valor * 3.5) + ((valor * 3.5) * 0.10));
				System.out.println("Tanque abastecido com sucesso");
			} else if (this.tanques[0] == 200 && (valor > 0)) {
				System.out.println("O tanque está cheio");
			} else if (valor <= 0) {
				System.out.println("Erro!");
			} else if ((this.tanques[0] + valor) > 200) {
				System.out.println("O valor excede a capacidade do tanque");
			}

		} else if (tanque == 2) {

			if ((this.tanques[1] + valor) <= 200 && (valor > 0)) {
				this.tanques[1] += valor;
				this.litrosComprados[1] += valor;
				this.litrosComprados[3] += valor;
				this.despesaCombustiveis += ((valor * 5.0) + ((valor * 5.0) * 0.20));
				System.out.println("Tanque abastecido com sucesso");
			} else if (this.tanques[1] == 200 && (valor > 0)) {
				System.out.println("O tanque está cheio");
			} else if (valor <= 0) {
				System.out.println("Erro!");
			} else if ((this.tanques[1] + valor) > 200) {
				System.out.println("O valor excede a capacidade do tanque");
			}

		} else if (tanque == 3) {

			if ((this.tanques[2] + valor) <= 200 && (valor > 0)) {
				this.tanques[2] += valor;
				this.litrosComprados[2] += valor;
				this.litrosComprados[3] += valor;
				this.despesaCombustiveis += ((valor * 4.25) + ((valor * 4.25) * 0.15));
				System.out.println("Tanque abastecido com sucesso");
			} else if (this.tanques[2] == 200 && (valor > 0)) {
				System.out.println("O tanque está cheio");
			} else if (valor <= 0) {
				System.out.println("Erro!");
			} else if ((this.tanques[2] + valor) > 200) {
				System.out.println("O valor excede a capacidade do tanque");
			}

		}
	}

	public void abastecerCarro(int auxCombustivel, float valor) {
		float auxLitros;

		if (auxCombustivel == 1) {

			auxLitros = (float)(valor / 3.50);

			if ((this.tanques[0] - auxLitros) >= 0 && (valor > 0)) {
				this.tanques[0] -= auxLitros;
				this.litrosVendidos[0] += auxLitros;
				this.litrosVendidos[3] += auxLitros;
				this.lucroCombustiveis += valor;
				System.out.println("Abastecimento efetuado\n" + auxLitros + " Litros");
			} else if (this.tanques[0] == 0 && (valor > 0)) {
				System.out.println("A bomba de Alcool está vazia");
			} else if (valor <= 0) {
				System.out.println("Erro!");
			} else if (auxLitros > this.tanques[0]) {
				System.out.println("Combustível insuficiente");
			}

		} else if (auxCombustivel == 2) {

			auxLitros = (float)(valor / 5.00);

			if ((this.tanques[1] - auxLitros) >= 0 && (valor > 0)) {
				this.tanques[1] -= auxLitros;
				this.litrosVendidos[1] += auxLitros;
				this.litrosVendidos[3] += auxLitros;
				this.lucroCombustiveis += valor;
				System.out.println("Abastecimento efetuado\n" + auxLitros + " Litros");
			} else if (this.tanques[1] == 0 && (valor > 0)) {
				System.out.println("A bomba de Gasolina está vazia");
			} else if (valor <= 0) {
				System.out.println("Erro!");
			} else if (auxLitros > this.tanques[1]) {
				System.out.println("Combustível insuficiente");
			}

		} else if (auxCombustivel == 3) {

			auxLitros = (float)(valor / 4.25);

			if ((this.tanques[2] - auxLitros) >= 0 && (valor > 0)) {
				this.tanques[2] -= auxLitros;
				this.litrosVendidos[2] += auxLitros;
				this.litrosVendidos[3] += auxLitros;
				this.lucroCombustiveis += valor;
				System.out.println("Abastecimento efetuado\n" + auxLitros + " Litros");
			} else if (this.tanques[2] == 0 && (valor > 0)) {
				System.out.println("A bomba de Diesel está vazia");
			} else if (valor <= 0) {
				System.out.println("Erro!");
			} else if (auxLitros > this.tanques[2]) {
				System.out.println("Combustível insuficiente");
			}
		}
	}

	public String relatorioTanques() {
		String auxRelatorioTanques = "";

		auxRelatorioTanques += "Situação atual dos tanques:\n";
		auxRelatorioTanques += "1 - Alcool: " + this.tanques[0] + " L\n";
		auxRelatorioTanques += "2 - Gasolina: " + this.tanques[1] + " L\n";
		auxRelatorioTanques += "3 - Diesel: " + this.tanques[2] + " L\n";

		return auxRelatorioTanques;
	}

	public String relatorioLucros() {
		String auxRelatorioLucros = "";

		auxRelatorioLucros += "Total:\n";
		auxRelatorioLucros += "Lucro bruto = R$ " + this.lucroCombustiveis + "\n";
		auxRelatorioLucros += "Lucro líquido = R$ " + (this.lucroCombustiveis - this.despesaCombustiveis) + "\n";
		return auxRelatorioLucros;
	}
}