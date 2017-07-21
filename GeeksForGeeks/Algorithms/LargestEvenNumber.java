// http://practice.geeksforgeeks.org/problems/largest-even-number/0

// 284918227595347128185772596567355423933679973674289434574127522843135379266

// print largest even number
/*
	used counting sort, and then print from largest to smallest 
	with saving one smallest even number i.e. 8, 6, 4, 2, 0
	and then printing the smallest even number at last if present
*/

import java.util.Scanner;

class LargestEvenNumber {
	public static void main(String[] args) {
		
		//code
		
		Scanner scanner = new Scanner(System.in);
		String n1 = scanner.nextLine();
		int n = Integer.parseInt(n1);
		
		int[] indexArr;
		int j, k;
		
		for(int i = 0; i < n; i++) {
		    indexArr = new int[10];
		    
		    String input1 = scanner.nextLine();
		    char[] arr = input1.toCharArray();
			
			for(int p = 0; p < arr.length; p++) {
				indexArr[Character.getNumericValue(arr[p])]++;
			}
			
			int even = -1;
			// find smallest even number
			for(j = 0; j < 10; j++) {
		        if(indexArr[j] > 0 && j%2 == 0) {
					even = j;
					break;
				}
		    }
			
		    for(j = 9; j > even; j--) {
		        for(k = 0; k < indexArr[j]; k++) {
		            System.out.print(j);
		        }
		    }
			
			if(even != -1) {
				for(k = 0; k < indexArr[even]-1; k++) {
					System.out.print(even);
				}
			}
			
			if(even > 0) {
				for(j = even - 1; j >= 0; j--) {
					for(k = 0; k < indexArr[j]; k++) {
						System.out.print(j);
					}
				}
			}
			
			if(even != -1) {
				System.out.print(even);
			}
			
		    System.out.println();
		}
	
	}
}