package analiseassintotica;

import java.util.Arrays;
import java.util.Scanner;

class TestesIO {
	
	//Insertion Sort Recursivo: Complexidade Quadrática
	public static void insereOrdenado(String[] v, int i) {
		int j = i;
		String aux = "";
			
		while (j >= 1 && v[j].compareTo(v[j-1]) < 0) {
			if (v[j].compareTo(v[j-1]) < 0){
				aux = v[j];
				v[j] = v[j-1];
				v[j-1] = aux;
			}
				
			j--;
		}
	}
		
		
	public static void insertionSortRecursivo(String[] v, int i) {
		if (i >= v.length) return;
		insereOrdenado(v, i);
		System.out.println(Arrays.toString(v).replace("]", "").replace("[", ""));
		insertionSortRecursivo(v, i+1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] v = sc.nextLine().split(",");
		
		insertionSortRecursivo(v, 0);
		
		sc.close();
	}
}
