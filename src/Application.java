import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

public class Application {

	public static void main(String[] args) {
		String[][] tabuleiro = new String[3][3];
		String posicaoLin;
		int posicaoCol;
		String posicao;
		Scanner leitor = new Scanner(System.in);
		String simbolo;
		boolean ganhador = false;
		boolean velha = false;
		Random gerador = new Random();
		int posicaoLinC, posicaoColC;
		String computador;
		
		simbolo = JOptionPane.showInputDialog("Informe o símbolo (X | O): ");
		String jogador = simbolo.toUpperCase();
		if (jogador.equalsIgnoreCase("x")) {
			computador = "O";
		} else {
			computador = "X";
		}

		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				System.out.print("a");
			} else if (i == 1) {
				System.out.print("b");
			} else {
				System.out.print("c");
			}
			for (int j = 0; j < 3; j++) {
				tabuleiro[i][j] = " ";
				System.out.print("|" + tabuleiro[i][j]);
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println(" |1|2|3|");

		while (ganhador == false || velha == false) {
			posicao = JOptionPane.showInputDialog("Informe a posição da jogada: ");
			posicaoLin = posicao.substring(0, 1);
			int posicaoLinN;
			if (posicaoLin.equalsIgnoreCase("a")) {
				posicaoLinN = 0;
			} else if (posicaoLin.equalsIgnoreCase("b")) {
				posicaoLinN = 1;
			} else {
				posicaoLinN = 2;
			}
			posicaoCol = Integer.valueOf(posicao.substring(1)) - 1;
			while (tabuleiro[posicaoLinN][posicaoCol] != " ") {
				System.out.print("Posição inválida");
				System.out.print("\nInforme a posição da jogada: ");
				posicao = leitor.next();
				posicaoLin = posicao.substring(0, 1);
				if (posicaoLin.equalsIgnoreCase("a")) {
					posicaoLinN = 0;
				} else if (posicaoLin.equalsIgnoreCase("b")) {
					posicaoLinN = 1;
				} else {
					posicaoLinN = 2;
				}
				posicaoCol = Integer.valueOf(posicao.substring(1)) - 1;
			}
			tabuleiro[posicaoLinN][posicaoCol] = jogador;
			posicaoLinC = gerador.nextInt(3);
			posicaoColC = gerador.nextInt(3);

			while (tabuleiro[posicaoLinC][posicaoColC] != " ") {
				posicaoLinC = gerador.nextInt(3);
				posicaoColC = gerador.nextInt(3);
			}
			tabuleiro[posicaoLinC][posicaoColC] = computador;

			if (tabuleiro[posicaoLinC][posicaoColC].equals(" ")) {
				tabuleiro[posicaoLinC][posicaoColC] = computador;
			}
			if (tabuleiro[0][0] == tabuleiro[0][1] && tabuleiro[0][1] == tabuleiro[0][2] && tabuleiro[0][0] != " ") {
				System.out.println(tabuleiro[0][0] + " ganhador.");
				ganhador = true;
				break;
			} else if (tabuleiro[1][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[1][2]
					&& tabuleiro[1][0] != " ") {
				System.out.println(tabuleiro[1][0] + " ganhador.");
				ganhador = true;
				break;
			} else if (tabuleiro[2][0] == tabuleiro[2][1] && tabuleiro[2][1] == tabuleiro[2][2]
					&& tabuleiro[2][0] != " ") {
				System.out.println(tabuleiro[2][0] + " ganhador.");
				ganhador = true;
				break;
			} else if (tabuleiro[0][0] == tabuleiro[1][0] && tabuleiro[1][0] == tabuleiro[2][0]
					&& tabuleiro[0][0] != " ") {
				System.out.println(tabuleiro[0][0] + " ganhador.");
				ganhador = true;
				break;
			} else if (tabuleiro[0][1] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][1]
					&& tabuleiro[0][1] != " ") {
				System.out.println(tabuleiro[0][1] + " ganhador.");
				ganhador = true;
				break;
			} else if (tabuleiro[0][2] == tabuleiro[1][2] && tabuleiro[1][2] == tabuleiro[2][2]
					&& tabuleiro[0][2] != " ") {
				System.out.println(tabuleiro[0][2] + " ganhador.");
				ganhador = true;
				break;
			} else if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]
					&& tabuleiro[0][0] != " ") {
				System.out.println(tabuleiro[0][0] + " ganhador.");
				ganhador = true;
				break;
			} else if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]
					&& tabuleiro[0][2] != " ") {
				System.out.println(tabuleiro[0][2] + " ganhador.");
				ganhador = true;
				break;
			}

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
		leitor.close();
	}
}