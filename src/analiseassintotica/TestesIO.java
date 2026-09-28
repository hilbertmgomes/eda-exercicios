package analiseassintotica;

import java.util.Arrays;
import java.util.Scanner;

class TestesIO {
	
	public static int escolherPivo(int[] v, int ini, int fim) {
		int meio = (ini + fim) / 2;
		int[] vals = new int[] {v[ini], v[meio], v[fim]};
		
		Arrays.sort(vals);
		
		if (vals[1] == v[ini]) return ini;
		else if (vals[1] == v[meio]) return meio;
		return fim;
		
	}
	
	public static int particionar(int[] v, int ini, int fim) {
		int pivo = escolherPivo(v, ini, fim);
		
		int i = ini;
		int j = fim;
		int aux = 0;
		
		while (i <= j) {
			while (i <= j && v[i] <= v[pivo]) {
				i++;
			}
			
			while (i <= j && v[j] > v[pivo]) {
				j--;
			}
			
			if (i < j) {
				aux = v[i];
				v[i] = v[j];
				v[j] = aux;
			}
		}
		
		aux = v[j];
		v[j] = v[pivo];
		v[pivo] = aux;
		
		return pivo;
		
	}
	
	public static void quickSort(int[] v, int ini, int fim) {
		if (ini < fim) {
			int pivo = particionar(v, ini, fim);
			quickSort(v, ini, pivo);
			quickSort(v, pivo+1, fim);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] v1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		quickSort(v1, 0, v1.length-1);
		System.out.println(Arrays.toString(v1));
		
		sc.close();
	}
}
