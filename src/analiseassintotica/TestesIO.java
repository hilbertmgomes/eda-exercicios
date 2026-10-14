package analiseassintotica;

import java.util.Arrays;
import java.util.Scanner;

class TestesIO {
	
	//Merge Sort: Complexidade n*log(n)
	public static void merge(int[] v, int ini, int fim) {
		int[] helper = new int[fim - ini + 1];
			
		for (int i = 0; i < fim - ini + 1; i++) {
			helper[i] = v[ini+i];
		}
		System.out.println(Arrays.toString(helper));
		
		int meio = (fim - ini) / 2;
			
		int i = 0;
		int j = meio + 1;
		int k = ini;
		
		while (i <= meio && j <= helper.length - 1) {
				
			if (helper[i] <= helper[j]) {
				v[k] = helper[i];
				i++;
			}else {
				v[k] = helper[j];
				j++;
			}
			k++;
		}
			
		while (i <= meio) {
			v[k] = helper[i];
			i++;
			k++;	
		}
			
	}
	
	public static void mergeSort(int[] v, int ini, int fim) {
		if (ini >= fim) {
			return;
		}
			
		int[] helper = new int[fim - ini + 1];
			
		for (int i = 0; i < fim - ini + 1; i++) {
			helper[i] = v[ini+i];
		}
			
		System.out.println(Arrays.toString(helper));
			
		int meio = (ini + fim) / 2;
		mergeSort(v, ini, meio);
		mergeSort(v, meio+1, fim);
		merge(v, ini, fim);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] v1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		mergeSort(v1, 0, v1.length-1);
		
		sc.close();
	}
}
