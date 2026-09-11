package analiseassintotica;

import java.util.Scanner;
import java.util.HashSet;

class TestesIO {
	
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		
		System.out.println(temRepetidoHashSet(input));
		
		sc.close();
	}
}
