// http://www.geeksforgeeks.org/insertion-sort/

/*
	Time Complexity - O(n^2)
	Space Complexity - O(1)
	
	Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order. 
	And it takes minimum time (Order of n) when elements are already sorted.
	
	Uses: Insertion sort is used when number of elements is small. It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.

	Algorithmic Paradigm: Incremental Approach

	Sorting In Place: Yes

	Stable: Yes

	Online: Yes
*/

class InsertionSort {
	
	static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			
			arr[j+1] = key;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Insertion Sort");
		
		int[] arr = new int[] {5, 2, 4, 3, 1};
		
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		insertionSort(arr);
		
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}