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
	
	//Encontra Primeiro Negativo: Complexidade Linear
	public static int primeiroNegativo(int[] v, int inicio) {
		if (inicio >= v.length) return -1;
		if (v[inicio]< 0) return v[inicio];
		
		return primeiroNegativo(v, inicio+1);
	}
	
	//Busca Linear Recursiva: Complexidade Linear
	public static int buscaLinearRecursiva(int[] v, int alvo, int inicio) {
		if (inicio >= v.length) return -1;
		if (v[inicio] == alvo) return inicio;
		
		return buscaLinearRecursiva(v, alvo, inicio+1);
	}
	
	//Potencia Recursiva: Complexidade Linear
	public static int potencia(int base, int exp, int reps) {
		if (reps >= exp) return 1;
		
		return base * potencia(base, exp, reps+1);
	}
	
	//Fibonacci: Complexidade Exponencial
	public static int fibonacci(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	//Busca Binaria: Complexidade Logarítmica
	public static int buscaBinaria(int[] v, int comeco, int fim, int alvo) {
		if (comeco > fim) return -1;
		int meio = (comeco + fim) / 2;
		if (v[meio] == alvo) return meio;
		
		if (v[meio] > alvo) {
			return buscaBinaria(v, comeco, meio-1, alvo);
		}
		
		return buscaBinaria(v, meio+1, fim, alvo);	
	}
}
