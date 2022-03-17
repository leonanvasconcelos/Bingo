package types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cartela {
	private static int contadorCartelasAtivas = 0;
	private int identificador;
	private List<Integer> numerosDaCartela;
	private final int QUANTIDADE_NUMEROS = 20;
	private int contadorNumerosMarcadosNaCartela;
	
	public Cartela() {
		populaCartela();
		Cartela.contadorCartelasAtivas++;
		identificador = Cartela.contadorCartelasAtivas;
	}
	
	private void populaCartela() {
		Integer numAleatorio;
		numerosDaCartela = new ArrayList<Integer>();
		for (int i = 0; i < QUANTIDADE_NUMEROS; i++) {
			do {
				numAleatorio = gerarNumAleatorio();
			} while (existeNaCartela(numAleatorio));
			numerosDaCartela.add(numAleatorio);
		}
		//Collections.sort(numerosDaCartela);
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
			contadorNumerosMarcadosNaCartela++;
		}

	}

	public boolean batida() {
		if (contadorNumerosMarcadosNaCartela == QUANTIDADE_NUMEROS)
			return true;
		else
			return false;
	}

	public int getIdentificador() {
		return identificador;
	}
}
