import javax.swing.JOptionPane;

public class Tabuleiro {
	private String[][] tabuleiro = new String[3][3];
	private Jogador jogador;
	private Cpu cpu;

	public Tabuleiro() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tabuleiro[i][j] = " ";
			}
		}
		jogador = new Jogador();
		cpu = new Cpu();
		if (jogador.getSimbolo().equalsIgnoreCase("X")) {
			String simboloCpu = "O";
			cpu.setCpu(simboloCpu);
		} else {
			String simboloCpu = "X";
			cpu.setCpu(simboloCpu);
		}
	}

	public void jogadaJogador() {
		int[] posicao = jogador.posicaoJogador();
		while (tabuleiro[posicao[0]][posicao[1]] != " ") {
			posicao = jogador.posicaoJogador();
		}
		tabuleiro[posicao[0]][posicao[1]] = jogador.getSimbolo();
	}

	public void jogadaCpu() {
		if (verificaGanhador() == null) {
			int[] posicao = cpu.posicaoCpu();
			while (tabuleiro[posicao[0]][posicao[1]] != " ") {
				posicao = cpu.posicaoCpu();
			}
			tabuleiro[posicao[0]][posicao[1]] = cpu.getCpu();
		}
	}

	public String verificaGanhador() {
		int cont = 0;
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2] && tabuleiro[i][0] != " ") {
				mostraTabuleiro();
				return tabuleiro[i][0];
			}
			if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i] && tabuleiro[0][i] != " ") {
				mostraTabuleiro();
				return tabuleiro[0][i];
			}
			for (int j = 0; j < 3; j++) {
				if (!tabuleiro[i][j].equals(" ")) {
					cont++;
				}
			}
		}
		if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[0][0] != " ") {
			mostraTabuleiro();
			return tabuleiro[0][0];
		}
		if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[0][2] != " ") {
			mostraTabuleiro();
			return tabuleiro[0][2];
		}
		if (cont == 9) {
			mostraTabuleiro();
			return "DEU VELHA";
		}
		return null;
	}

	public void ganhador() {
		if (verificaGanhador() != null) {
			JOptionPane.showConfirmDialog(null, verificaGanhador().toUpperCase() + " VENCEU.");
		} else if (verificaGanhador() == "DEU VELHA") {
			JOptionPane.showConfirmDialog(null, "DEU VELHA");
		}
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