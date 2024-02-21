import javax.swing.JOptionPane;

public class Tabuleiro {
	private String[][] tabuleiro = new String[3][3];
	private Jogador jogador;

	public Tabuleiro() {
		String simbolo = JOptionPane.showInputDialog("Informe o símbolo (X | O): ");
		jogador.setSimbolo(simbolo);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tabuleiro[i][j] = " ";
			}
		}
	}
}
