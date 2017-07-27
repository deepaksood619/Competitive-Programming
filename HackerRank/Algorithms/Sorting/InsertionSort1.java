// https://www.hackerrank.com/challenges/insertionsort1

/*
	Time Complexity - O(n^2)
	Space Complexity - O(1)
*/

import java.util.Scanner;

class InsertionSort1 {
	
	static void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		
		int[] arr = new int[size];
		
		for(int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		
		int key = arr[size-1];
		
		int i = size - 2;
		while(i >= 0 && arr[i] > key) {
			arr[i+1] = arr[i];
			i--;
			print(arr);
		}
		arr[i+1] = key;
		print(arr);
	}
	
}