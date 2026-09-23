package analiseassintotica;

import java.util.Arrays;
import java.util.Scanner;

class TestesIO {
	
	//Selection Sort Otimizado: Complexidade Quadrática
	public static void selectionSortOtimizado(int[] v) {
		int maior = 0;
		int menor = 0;
		int aux = 0;
		int i_rev = v.length-1;
		
		for (int i = 0; i < v.length / 2; i++) {
			maior = i_rev;
			menor = i;
			
			for (int j = i; j <= i_rev; j++) {
				if (v[j] > v[maior]) {
					maior = j;
				} 
				
				if (v[j] < v[menor]) {
					menor = j;
				}
			}
			
			aux = v[i];
			v[i] = v[menor];
			v[menor] = aux;
			
			if (i == maior) {
				maior = menor;
			}
				
			aux = v[i_rev];
			v[i_rev] = v[maior];
			v[maior] = aux;

			
			i_rev--;
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] v = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		selectionSortOtimizado(v);
		System.out.println(Arrays.toString(v));
		
		sc.close();
	}
}
