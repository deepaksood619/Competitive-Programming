// http://www.geeksforgeeks.org/iterative-quick-sort/

/*
Problem with recursive Quick Sort - 
The function remains recursive and uses function call stack to store intermediate values of l and h. The function call stack stores other bookkeeping information together with parameters. Also, function calls involve overheads like storing activation record of the caller function and then resuming execution.

Recursive Quick Sort can be easily converted to iterative version with the help of an auxiliary stack. Following is an iterative implementation of the recursive code.
*/

class IterativeQuickSort {

	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;

		for(int j = low; j < high; j++) {
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

	static void iterativeQuickSort(int[] arr, int low, int high) {
		int[] stack = new int[high - low + 1];
		int top = -1;

		stack[++top] = low;
		stack[++top] = high;

		while(top >= 0) {
			high = stack[top--];
			low = stack[top--];

			int pi = partition(arr, low, high);

			if(pi-1 > low) {
				stack[++top] = low;
				stack[++top] = pi - 1;
			}

			if(pi + 1 < high) {
				stack[++top] = pi + 1;
				stack[++top] = high;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] {3, 1, 4, 2};
		int N = arr.length;

		iterativeQuickSort(arr, 0, N-1);

		for(int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}