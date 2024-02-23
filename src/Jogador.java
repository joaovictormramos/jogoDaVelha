import javax.swing.JOptionPane;

public class Jogador {
	private String simbolo;

	public Jogador() {
		simbolo = JOptionPane.showInputDialog("Informe o símbolo (X|O): ");
	}

	public String getSimbolo() {
		return simbolo;
	}

	public int[] posicaoJogador() {
		String posicao = JOptionPane.showInputDialog("Informe a posição da jogada: ");
		String posicaoLin = posicao.substring(0, 1);
		int posicaoLinN;
		if (posicaoLin.equalsIgnoreCase("a")) {
			posicaoLinN = 0;
		} else if (posicaoLin.equalsIgnoreCase("b")) {
			posicaoLinN = 1;
		} else {
			posicaoLinN = 2;
		}
		int posicaoCol = Integer.valueOf(posicao.substring(1)) - 1;
		int posicaoInt[] = { posicaoLinN, posicaoCol };
		return posicaoInt;
	}
}