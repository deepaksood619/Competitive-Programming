// http://www.geeksforgeeks.org/recursive-bubble-sort/

/*
	Optimized Bubble Sort - Stop the algorithm if inner loop didn’t cause any swap.

	Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.

	Best Case Time Complexity: O(n). Best case occurs when array is already sorted.

	Auxiliary Space: O(1)

	Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.

	Sorting In Place: Yes

	Stable: Yes
*/

class RecursiveBubbleSort {
	
	static void sort(int[] arr, int n) {
		if(n == 1)
			return;
		
		boolean swapped = false;
		for(int i = 0; i < n-1; i++) {
			if(arr[i] > arr[i+1]) {
				swapped = true;
				int t = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = t;
			}
		}
		
		if(!swapped) {
			return;
		}
		sort(arr, n-1);
	}
	
	public static void main(String[] args) {
		System.out.println("Bubble Sort");
		
		int[] arr = new int[] {8, 2, 3, 4, 5, 6, 7, 1};
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		sort(arr, arr.length);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}