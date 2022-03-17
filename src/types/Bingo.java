package types;

import java.util.ArrayList;
import java.util.List;

public class Bingo {
	/*TODO debugar as cartelas ao final da execução
	*TODO criar método para retornar os números da cartela vencedora
	*/
	private List<Cartela> cartelas;
	private List<Integer> idCartelasBatidas;
	private List<Integer> listaNumerosChamados;
	private Globo globo;	

	public Bingo(int quantidadeCartelas){
		globo = new Globo();
		idCartelasBatidas = new ArrayList<Integer>();
		listaNumerosChamados = new ArrayList<Integer>();
		criarCartelas(quantidadeCartelas);
	}

	public Bingo() {
		this(5);
	}

	public void comecarBingo() {
		System.out.println("Vamos come�ar o bingo!");
		do {
			int numeroChamado = globo.sortearNumero();
			System.out.println((listaNumerosChamados.size() + 1) + "� bola: " + numeroChamado);
			marcarCartelas(numeroChamado);
			listaNumerosChamados.add(numeroChamado);
		}while (!temCartelasBatidas());
		System.out.println("BINGO!\nAs cartelas premiadas s�o: \n" + idCartelasBatidas.toString());
	}

	private void criarCartelas(int quantidade) {
		cartelas = new ArrayList<Cartela>();
		for (int i = 0; i < quantidade; i++) {
			cartelas.add(new Cartela());
		}
	}

	public void marcarCartelas(int numeroSorteado) {
		for (Cartela c : cartelas) {
			c.marcarNumero(numeroSorteado);
		}
	}

	private boolean temCartelasBatidas() {
		boolean result = false;
		for (Cartela c : cartelas) {
			if (c.batida()){
				result = true;
				idCartelasBatidas.add(c.getIdentificador());
			}
		}
		return result;
	}
	
}
