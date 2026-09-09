package analiseassintotica;

public class ListaClassroom {
	
	//Questão 1: Complexidade Linear
	public static void trocaVizinhos(int[] v) {
		int temp = 0;
		
		for(int i = 0; i < v.length-1; i+=2) {
			temp = v[i];
			v[i] = v[i+1];
			v[i+1] = temp;
		}
	}
	
	//Questão 2: Complexidade Linear
	public static boolean ehPalindromo(char[] palavra) {
		int fim = palavra.length - 1;
		
		for (int i = 0; i < palavra.length / 2; i++) {
			if (palavra[i] != palavra[fim]) {
				return false;
			}
			
			fim--;
		}
		
		return true;
	}
	
	//Questão 3: Complexidade Quadrática
	public static int[] twoSum(int[] v, int target) {
		for (int i = 0; i < v.length; i++) {
			for (int j = i+1; j < v.length; j++) {
				if (v[i] + v[j] == target) {
					return new int[] {v[i], v[j]};
				}
			}
		}
		
		return null;
	}
	
	//Questão 4: Complexidade Linear
	public static boolean ehPrimo(int n) {
		int fat = 2;
		
		while (fat < n) {
			if (n % fat == 0) {
				return false;
			}
			
			fat++;
		}
		
		return true;
	}
	
	//Questão 5: Complexidade Quadrática
	public static boolean temRepetido(int[] v) {
		for (int i = 0; i < v.length; i++) {
			for (int j = i+1; j < v.length; j++) {
				if (v[i] == v[j]) {
					return true;
				}
			}
		}
		return false;
	}
}
