package leda01;

import java.util.HashSet;

public class Algoritmos {
	
	//Complexidade quadrática
	public static boolean temRepetido(String[] v) {
		for (int i = 0; i < v.length; i++) {
			for (int j = i+1; j < v.length; j++) {
				if (v[i].equals(v[j])) {
					return true;
				}
			}
		}
		return false;
	}
	
	//Complexidade linear
	public static boolean temRepetidoHashSet(String[] v) {
		HashSet<String> vals = new HashSet<>();
		
		for (String val : v) {
			if (vals.contains(val)) {
				return true;
			}
			vals.add(val);
		}
		return false;
	}
}
