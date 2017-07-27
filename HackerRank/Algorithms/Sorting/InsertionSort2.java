// https://www.hackerrank.com/challenges/insertionsort2

/*
	Time Complexity - O(n^2)
	Space Complexity - O(1)
	
Test Case 1
6
1 4 3 5 6 2

*/

import java.util.Scanner;

class InsertionSort2 {
	
	public static void insertionSortPart2(int[] ar)
    {
        int len = ar.length;
        
        for(int i = 1; i < len; i++) {
            int key = ar[i];
            int j = i - 1;
            
            while(j >=0 && key < ar[j]) {
                ar[j+1] = ar[j];
                j--;
            }
            ar[j+1] = key;
            printArray(ar);
        }
        
    }  
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
   
}