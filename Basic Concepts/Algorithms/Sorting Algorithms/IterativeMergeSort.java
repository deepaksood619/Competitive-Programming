// http://www.geeksforgeeks.org/iterative-merge-sort/

/*
Recursive implementation uses function call stack to store intermediate values of l and h.
The function call stack stores other bookkeeping information together with parameters.
Also, function calls involve overheads like storing activation record of the caller function and then resuming execution. 
Unlike Iterative QuickSort, the iterative MergeSort doesn’t require explicit auxiliary stack.

Auxiliary Space: O(n)

Algorithmic Paradigm: Divide and Conquer

Sorting In Place: No in a typical implementation

Stable: Yes

*/

class IterativeMergeSort {

	static void merge(int[] arr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];

		for(int i = 0; i < n1; i++) {
			leftArr[i] = arr[left + i];
		}
		for(int j = 0; j < n2; j++) {
			rightArr[j] = arr[mid + j + 1];
		}

		int i = 0, j = 0, k = left;

		while(i < n1 && j < n2) {
			if(leftArr[i] < rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}

		while(i < n1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}

		while(j < n2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}

	static void mergeSort(int[] arr, int n) {

		int left_index;
		int current_size;

		for(current_size = 1; current_size < n-1; current_size = current_size*2) {
			for(left_index = 0; left_index < n-1; left_index += 2 * current_size) {
				int mid = left_index + current_size - 1;

				int right_index = min(left_index + 2*current_size - 1, n-1);

				merge(arr, left_index, mid, right_index);
			}
		}

	}

	static int min(int a, int b) {
		if(a < b) return a;
		else return b;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {4, 3, 1, 2};

		mergeSort(arr, arr.length);

		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}