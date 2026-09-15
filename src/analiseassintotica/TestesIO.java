package analiseassintotica;

import java.util.Arrays;
import java.util.Scanner;

class TestesIO {
	
	public static int buscaBinaria(int[] v, int comeco, int fim, int alvo) {
		if (comeco > fim) return -1;
		int meio = (comeco + fim) / 2;
		if (v[meio] == alvo) return meio;
		
		System.out.println(meio);
		if (v[meio] > alvo) {
			return buscaBinaria(v, comeco, meio-1, alvo);
		}
		
		return buscaBinaria(v, meio+1, fim, alvo);	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] v = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int alvo = sc.nextInt();
		
		System.out.println(buscaBinaria(v, 0, v.length-1, alvo));
		
		sc.close();
	}
}
