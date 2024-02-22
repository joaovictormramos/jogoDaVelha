import java.util.Random;

public class Cpu {
	private String cpu;

	public int[] posicaoCpu() {
		Random gerador = new Random();
		int posicaoLinCpu = gerador.nextInt(3);
		int posicaoColCpu = gerador.nextInt(3);
		int[] posicaoCpu = { posicaoLinCpu, posicaoColCpu };
		return posicaoCpu;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
}