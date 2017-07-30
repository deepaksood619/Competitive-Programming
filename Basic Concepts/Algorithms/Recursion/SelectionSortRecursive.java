// http://www.geeksforgeeks.org/practice-questions-for-recursion/

class SelectionSortRecursive {
	
	static void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	static void selectionSort(int[] arr, int startIndex, int endIndex) {
		if(startIndex >= endIndex) {
			return;
		}
		
		int min = startIndex;
		for(int i = startIndex+1; i < endIndex; i++) {
			if(arr[i] < arr[min]) {
				min = i;
			}
		}
		
		int temp = arr[startIndex];
		arr[startIndex] = arr[min];
		arr[min] = temp;
		
		selectionSort(arr, startIndex + 1, endIndex);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {4, 2, 1, 3};
		
		int n = arr.length;
		
		print(arr);
		System.out.println();
		
		// selection sort recursive
		selectionSort(arr, 0, n);
		
		print(arr);
		
	}
}