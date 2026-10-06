package analiseassintotica;

import java.util.Arrays;
import java.util.Scanner;

class TestesIO {
	
	//Radix Sort: Complexidade O(d * n)
	public static void radixSort(int[] v, int digitos) {
		for (int d = 1; d <= digitos; d++) {
			countingRadixSort(v, d);
		}
	}
		
		
	public static void countingRadixSort(int[] v, int exp) {
		int[] aux = new int[19];
		int fat1 = (int) Math.pow(10, exp);
		int fat2 = (int) Math.pow(10, exp-1);
			
		for (int i = 0; i < v.length; i++) {
			aux[(((v[i] % fat1) - (v[i] % fat2)) / fat2) + 9]++;
		}
			
		for (int i = 1; i < aux.length; i++) {
			aux[i] = aux[i] + aux[i-1];
		}
		
		int[] out = new int[v.length];
			
		for (int i = v.length-1; i >= 0; i--) {
			out[aux[(((v[i] % fat1) - (v[i] % fat2)) / fat2) + 9] - 1] = v[i];
			aux[(((v[i] % fat1) - (v[i] % fat2)) / fat2) + 9]--;		
		}
		
		for (int i = 0; i < v.length; i++) {
			v[i] = out[i];
		}
	}
		

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] v1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		radixSort(v1, 4);
		System.out.println(Arrays.toString(v1));
		
		sc.close();
	}
}
