// http://practice.geeksforgeeks.org/problems/sort-the-array/0
/*
 Used Quick Sort Algorithm
*/
import java.util.Scanner;

class SortTheArray
 {
     
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        
        int i = low -1;
        
        for(int j = low; j <= high-1; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    
    static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
     
	public static void main (String[] args)
	 {
	    Scanner in = new Scanner(System.in);
	    int T = in.nextInt();
	    while(T-- > 0) {
	        int N = in.nextInt();
	        int[] arr = new int[N];
	        
	        for(int i = 0; i < N; i++) {
	            arr[i] = in.nextInt();
	        }
	        
	        quickSort(arr, 0, N-1);
	        
	        for(int i = 0; i < N; i++) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }
	 }
}
