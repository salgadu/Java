import javax.swing.JOptionPane;

public class Sistema {
	public static void main(String[] args) {
		int opcA,
		opcB,
		opcC,
		opcD,
		opcE;

		Posto posto = new Posto();
		JOptionPane.showMessageDialog(null, "Posto Fidelidade! Vem abastecer voce tambem", "Bem Vindo", JOptionPane.INFORMATION_MESSAGE);

		String menuA = "";
		String menuB = "";
		String menuC = "";
		String menuD = "";
		String menuE = "";

		menuA += "Escolha uma opcao\n";
		menuA += "1 - Posto\n";
		menuA += "2 - Vendas\n";
		menuA += "0 - Sair\n";

		menuB += "Escolha uma opcao\n";
		menuB += "1 - Abastecimento dos tanques\n";
		menuB += "2 - Relatório dos tanques\n";
		menuB += "3 - Relatório de lucros\n";
		menuB += "0 - Voltar";

		menuC += "Escolha o tanque a ser abastecido\n";
		menuC += "1 - Alcool\n";
		menuC += "2 - Gasolina\n";
		menuC += "3 - Diesel\n";
		menuC += "0 - Voltar";

		menuD += "Escolha uma opcao\n";
		menuD += "1 - Abastecimento\n";
		menuD += "0 - Voltar";

		menuE += "Escolha o combustível que deseja abastecer:\n";
		menuE += "1 - Alcool\n";
		menuE += "2 - Gasolina\n";
		menuE += "3 - Diesel\n";
		menuE += "0 - Voltar";

		do {
			opcA = Integer.parseInt(JOptionPane.showInputDialog(null, menuA, "Posto Fidelidade", JOptionPane.INFORMATION_MESSAGE));
			if (opcA == 1) {
				do {
					opcB = Integer.parseInt(JOptionPane.showInputDialog(null, menuB, "ADM", JOptionPane.INFORMATION_MESSAGE));
					if (opcB == 1) {
						do {
							opcC = Integer.parseInt(JOptionPane.showInputDialog(null, menuC, "Abastecimento dos Tanques", JOptionPane.INFORMATION_MESSAGE));
							if (opcC == 1) {
								int auxAlcool = Integer.parseInt(JOptionPane.showInputDialog(null, "Tanque de Alcool\nDigite o valor a ser abastecido:", "Alcool", JOptionPane.INFORMATION_MESSAGE));
								posto.abastecerTanque(opcC, auxAlcool);
							}
							else if (opcC == 2) {
								int auxGasolina = Integer.parseInt(JOptionPane.showInputDialog(null, "Tanque de Gasolina\nDigite o valor a ser abastecido:", "Gasolina", JOptionPane.INFORMATION_MESSAGE));
								posto.abastecerTanque(opcC, auxGasolina);
							}
							else if (opcC == 3) {
								int auxDiesel = Integer.parseInt(JOptionPane.showInputDialog(null, "Tanque de Diesel\nDigite o valor a ser abastecido:", "Diesel", JOptionPane.INFORMATION_MESSAGE));
								posto.abastecerTanque(opcC, auxDiesel);
							}
							else if (opcC != 0) {
								JOptionPane.showMessageDialog(null, "Opcao invalida", "Erro", JOptionPane.ERROR_MESSAGE);
							}
						} while ( opcC != 0 );
					} else if (opcB == 2) {
						JOptionPane.showMessageDialog(null, posto.relatorioTanques(), "Relatório dos Tanques", JOptionPane.INFORMATION_MESSAGE);
					} else if (opcB == 3) {
						JOptionPane.showMessageDialog(null, posto.relatorioLucros(), "Relatório dos Lucros", JOptionPane.INFORMATION_MESSAGE);
					} else if (opcB != 0) {
						JOptionPane.showMessageDialog(null, "Opcao invalida", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				} while ( opcB != 0 );

			} else if (opcA == 2) {
				do {
					opcD = Integer.parseInt(JOptionPane.showInputDialog(null, menuD, "Posto Fidelidade", JOptionPane.INFORMATION_MESSAGE));
					if (opcD == 1) {
						do {
							opcE = Integer.parseInt(JOptionPane.showInputDialog(null, menuE, "Bombas de combustível", JOptionPane.INFORMATION_MESSAGE));
							if (opcE == 1) {
								float auxAlcoolA = Float.parseFloat(JOptionPane.showInputDialog(null, "Bomba de Alcool\nDigite o valor em R$ a ser abastecido:", "Alcool", JOptionPane.INFORMATION_MESSAGE));
								posto.abastecerCarro(opcE, auxAlcoolA);
							} else if (opcE == 2) {
								float auxGasolinaA = Float.parseFloat(JOptionPane.showInputDialog(null, "Bomba de Gasolina\nDigite o valor em R$ a ser abastecido:", "Gasolina", JOptionPane.INFORMATION_MESSAGE));
								posto.abastecerCarro(opcE, auxGasolinaA);
							} else if (opcE == 3) {
								float auxDieselA = Float.parseFloat(JOptionPane.showInputDialog(null, "Bomba de Diesel\nDigite o valor em R$ a ser abastecido:", "Diesel", JOptionPane.INFORMATION_MESSAGE));
								posto.abastecerCarro(opcE, auxDieselA);
							} else if (opcE != 0) {
								JOptionPane.showMessageDialog(null, "Opcao invalida", "Erro", JOptionPane.ERROR_MESSAGE);
							}
						} while ( opcE != 0 );
					} else if (opcD != 0) {
						JOptionPane.showMessageDialog(null, "Opcao invalida", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				} while ( opcD != 0 );
			} else if (opcA != 0) {
				JOptionPane.showMessageDialog(null, "Opcao invalida", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		} while ( opcA != 0 );
	}
}