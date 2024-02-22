import javax.swing.JOptionPane;

public class Tabuleiro {
	private String[][] tabuleiro = new String[3][3];

	public Tabuleiro() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tabuleiro[i][j] = " ";
			}
		}
	}

	public void jogadaJogador(int[] posicao, Jogador jogador) {
		if (tabuleiro[posicao[0]][posicao[1]] == " ") {
			tabuleiro[posicao[0]][posicao[1]] = jogador.getSimbolo();
		} else {
			posicao = jogador.posicaoJogador();
			while (tabuleiro[posicao[0]][posicao[1]].equalsIgnoreCase("x")
					|| tabuleiro[posicao[0]][posicao[1]].equalsIgnoreCase("o")) {
				int[] novaPosicao = jogador.posicaoJogador();
				tabuleiro[novaPosicao[0]][novaPosicao[1]] = jogador.getSimbolo();
			}
		}
	}

	public void jogadaCpu(int[] posicao, Cpu cpu) {
		if (tabuleiro[posicao[0]][posicao[1]] == " ") {
			tabuleiro[posicao[0]][posicao[1]] = cpu.getCpu();
		} else {
			while (tabuleiro[posicao[0]][posicao[1]].equalsIgnoreCase("x")
					|| tabuleiro[posicao[0]][posicao[1]].equalsIgnoreCase("o")) {
				int[] novaPosicao = cpu.posicaoCpu();
				tabuleiro[novaPosicao[0]][novaPosicao[1]] = cpu.getCpu();
			}
		}
	}

	public String verificaGanhador() {
		String ganhador = null;
		if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[0][0] != " ") {
			JOptionPane.showMessageDialog(null, tabuleiro[0][0] + " ganhador.");
			return ganhador = tabuleiro[0][0];
		} else if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[0][2] != " ") {
			JOptionPane.showMessageDialog(null, tabuleiro[2][2] + " ganhador.");
			return ganhador = tabuleiro[0][2];
		}
		for (int i = 0; i < 3; i++) {
			int j = 0;
			if (tabuleiro[i][j] == tabuleiro[i][j + 1] && tabuleiro[i][j + 1] == tabuleiro[i][j + 2]
					&& tabuleiro[i][j] != " ") {
				JOptionPane.showMessageDialog(null, tabuleiro[i][j] + " ganhador.");
				return ganhador = tabuleiro[i][j];
			}
		}
		for (int j = 0; j < 3; j++) {
			int i = 0;
			if (tabuleiro[j][i] == tabuleiro[j][i + 1] && tabuleiro[j][i + 1] == tabuleiro[j][i + 2]
					&& tabuleiro[j][i] != " ") {
				JOptionPane.showMessageDialog(null, tabuleiro[j][i] + " ganhador.");
				return ganhador = tabuleiro[j][i];
			}
		}
		return null;
	}

	public boolean velha() {
		int cont = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tabuleiro[i][j] != " ") {
					cont++;
					if (cont == 9) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void mostraTabuleiro() {
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				System.out.print("a|");
			} else if (i == 1) {
				System.out.print("b|");
			} else {
				System.out.print("c|");
			}
			for (int j = 0; j < 3; j++) {
				System.out.print(tabuleiro[i][j]);
				System.out.print("|");
			}
			System.out.println();
		}
		System.out.println(" |1|2|3|");
	}
}