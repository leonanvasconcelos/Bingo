package types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Globo {
	private List<Integer> numeros;
	
	public Globo() {
		numeros = new ArrayList<Integer>();
		for (int i = 1; i < 100; i++) {
			numeros.add(i);
		}
		Collections.shuffle(numeros);
		
	}
	public int sortearNumero() {
		int result;
		result = numeros.get(0);
		numeros.remove(0);
		return result;
	}

}
