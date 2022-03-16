package types;

import java.util.ArrayList;
import java.util.List;

public class Bingo {
	/*
	 * TODO método para chamar o globo propriedade que guarda os números chamados
	 * método para marcar cartelas método para receber o(s) números identificadores
	 * de cada
	 */
	private List<Cartela> cartelas;
	private List<Integer> idCartelasBatidas;
	private Globo globo;

	public Bingo() {
		globo = new Globo();
		idCartelasBatidas = new ArrayList<Integer>();
		criarCartelas(1000);
	}

	public void startBingo() {
		do {
			int numero = globo.sortearNumero();
			System.out.println("O número " + numero + " foi sorteado.");
			marcarCartelas(numero);
			// conferirCartelas();
		} while (!temCartelasBatidas());
		listarCartelasBatidas();
	}

	private void criarCartelas(int quantidade) {
		cartelas = new ArrayList<Cartela>();
		for (int i = 0; i < quantidade; i++) {
			cartelas.add(new Cartela());
		}
	}

	public void marcarCartelas(int numeroSorteado) {
		// TODO Auto-generated method stub
		for (Cartela c : cartelas) {
			c.marcarNumero(numeroSorteado);
		}
	}

	public void listarCartelasBatidas() {
		for (int i = 0; i <= idCartelasBatidas.size() - 1; i++) {
			System.out.println("A cartela " + idCartelasBatidas.get(i) + " bateu.");
		}
	}

	/*
	 * private void conferirCartelas() { // remover metodo, nao tem utilidade ja que
	 * no temCartelasBatidas() //está sendo acrescentado no no array de batidas. if
	 * (!idCartelasBatidas.isEmpty()) {
	 * 
	 * } }
	 */

	private boolean temCartelasBatidas() {
		boolean result = false;
		for (Cartela c : cartelas) {
			if (c.batida()) {
				result = true;
				idCartelasBatidas.add(c.getIdentificador());
			}
		}

		return result;
	}

}
