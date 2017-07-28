// http://www.geeksforgeeks.org/recursive-insertion-sort/

/*
	Time Complexity - O(n*n)
	Space Complexity - O(1)
	
	in place - yes
	Stable - yes
	online - yes
*/

class RecursiveInsertionSort {
	
	static void recursiveInsertionSort(int[] arr, int n) {
		
		if(n <= 1)
			return;
		
		recursiveInsertionSort(arr, n-1);
		
		int key = arr[n-1];
		int j = n - 2;
			
		while(j >= 0 && arr[j] > key) {
			arr[j+1] = arr[j];
			j = j-1;
		}
			
		arr[j+1] = key;
	}
	
	public static void main(String[] args) {
		System.out.println("Recursive Insertion Sort");
		
		int[] arr = new int[] {5, 2, 4, 3, 1};
		
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		recursiveInsertionSort(arr, arr.length);
		
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
}