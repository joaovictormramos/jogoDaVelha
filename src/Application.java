import javax.swing.JOptionPane;

public class Application {

	public static void main(String[] args) {
		String simbolo = JOptionPane.showInputDialog("Informe o símbolo (X|O): ");
		Jogador jogador = new Jogador(simbolo);
		Cpu cpu = new Cpu();
		
		if (jogador.getSimbolo().equalsIgnoreCase("X")) {
			String simboloCpu = "O";
			cpu.setCpu(simboloCpu);
		} else {
			String simboloCpu = "X";
			cpu.setCpu(simboloCpu);
		}
		Tabuleiro tabuleiro = new Tabuleiro();
		while (tabuleiro.verificaGanhador() == null && tabuleiro.velha() == false) {
			int[] posicaoJogador = jogador.posicaoJogador();
			tabuleiro.jogadaJogador(posicaoJogador, jogador);
			int[] posicaoCpu = cpu.posicaoCpu();
			tabuleiro.jogadaCpu(posicaoCpu, cpu);
			tabuleiro.mostraTabuleiro();
		}
		System.out.println();
	}
}