package types;

import java.util.ArrayList;
import java.util.List;

public class Cartela {
	/* TODO refatoração
	 * otimizar checagem do PopularCartela
	 */
	public static int objectCount = 0;
	private int identificador;
	private List<Integer> numerosDaCartela;
	private final int QUANTIDADE_NUMEROS = 20;
	private int contadorMarcados;
	private boolean bateu;
	
	public Cartela() {
		bateu = false;
		populaCartela();
		Cartela.objectCount++;
		identificador = Cartela.objectCount;
	}
	
	private void populaCartela() {
		Integer randomNumber;
		numerosDaCartela = new ArrayList<Integer>();
		for (int i = 0; i < QUANTIDADE_NUMEROS; i++) {
			do {
				randomNumber = gerarNumAleatorio();
			} while (existeNaCartela(randomNumber));
			numerosDaCartela.add(randomNumber);
		}
	}
	
	private boolean existeNaCartela(Integer n) {
		if (numerosDaCartela.contains(n)) { 
			return true;
		}
		return false;
	}
	
	private Integer gerarNumAleatorio() {
		return (int)(Math.random() * 99) +1;
	}
	
	public void marcarNumero(int n) {
		if (existeNaCartela(n)) {
			contadorMarcados++;
		}
		if (contadorMarcados == 20) {
			bateu = true;
		}
	}

	public boolean batida() {
		return bateu;
	}

	public int getIdentificador() {
		return identificador;
	}
}
