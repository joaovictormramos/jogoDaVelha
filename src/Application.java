public class Application {

	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro();
		while (!tabuleiro.verificaGanhador() || !tabuleiro.velha()) {
			tabuleiro.jogadaJogador();
			tabuleiro.jogadaCpu();
			tabuleiro.mostraTabuleiro();
		}
	}
}