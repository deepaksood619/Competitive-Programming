// http://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/

/*

	Problem - You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.

	Solution - The greedy choice is to always pick the next activity whose finish time is least among the remaining activities and the start time is more than or equal to the finish time of previously selected activity.

	Algorithmic Approach - Greedy Algorithm

	Time Complexity - O(N*log(N))
	Space Complexity - O(1)

----------------------------------------------------------------------------------------------------
	Arrays.sort() method documentation - 
This sort is guaranteed to be stable: equal elements will not be reordered as a result of the sort.

Implementation note: This implementation is a stable, adaptive, iterative mergesort that requires far fewer than n lg(n) comparisons when the input array is partially sorted, while offering the performance of a traditional mergesort when the input array is randomly ordered. If the input array is nearly sorted, the implementation requires approximately n comparisons. Temporary storage requirements vary from a small constant for nearly sorted input arrays to n/2 object references for randomly ordered input arrays.

The implementation takes equal advantage of ascending and descending order in its input array, and can take advantage of ascending and descending order in different parts of the the same input array. It is well-suited to merging two or more sorted arrays: simply concatenate the arrays and sort the resulting array.

The implementation was adapted from Tim Peters's list sort for Python ( TimSort).
----------------------------------------------------------------------------------------------------
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

class UnsortedActivitySelectionProblem {

	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low-1;

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
				stack[++top] = pi-1;
			}

			if(pi+1 < high) {
				stack[++top] = pi+1;
				stack[++top] = high;
			}
		}
	}

	static void merge(int[] arr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];

		for(int i = 0; i < n1; i++) {
			leftArr[i] = arr[left + i];
		}

		for(int i = 0; i < n2; i++) {
			rightArr[i] = arr[mid + i + 1];
		}

		int i = 0, j = 0, k = left;
		while(i < n1 && j < n2) {
			if(leftArr[i] <= rightArr[j]) {
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

	static void mergeSort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = (left + right)/2;

			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);

			merge(arr, left, mid, right);
		}
	}

	static void iterativeMergeSort(int[] arr, int N) {
		int current_size = 0;
		int left_start = 0;

		for(current_size = 1; current_size < N-1; current_size = current_size * 2) {
			for(left_start = 0; left_start < N-1; left_start += current_size * 2) {
				int mid = left_start + current_size - 1;
				int check = left_start + current_size*2 - 1;
				int right_end;
				if(check <= N-1) {
					right_end = check;
				} else {
					right_end = N-1;
				}

				merge(arr, left_start, mid, right_end);
			}
		}
	}

	public static void main(String[] args) {
		//int[] start = new int[] {5, 8, 5, 0, 3, 1};
		//int[] finish = new int[] {9, 9, 7, 6, 4, 2};

		// quickSort(finish, 0, finish.length-1);
		// iterativeQuickSort(finish, 0, finish.length - 1);
		// mergeSort(finish, 0, finish.length-1);
		// iterativeMergeSort(finish, finish.length);

		Integer[][] arr = new Integer[][] {{5, 9}, {8, 9}, {5, 7}, {0, 6}, {1, 2}, {3, 4}};
		LinkedList<Integer> selectedIndexArr = new LinkedList<>();
		LinkedList<Integer[]> selectedArr = new LinkedList<>();

		Arrays.sort(arr, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] a, Integer	[] b) {
				return Integer.compare(a[1], b[1]);
			}
		});

		// sorted array
		System.out.println("Sorted array");
		for(Integer i = 0; i < arr.length; i++) {
			for(Integer j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]  + " ");
			}
			System.out.println();
		}
		System.out.println();
		

		int count = 0;
		int selected_index = 0;
		if(arr.length > 0) {
			count++;
			selected_index = 0;
			selectedIndexArr.add(selected_index);
			selectedArr.add(arr[0]);
		}

		for(int i = 1; i < arr.length; i++) {
			if(arr[i][0] >= arr[selected_index][1]) {
				count++;
				selected_index = i;
				selectedIndexArr.add(selected_index);
				selectedArr.add((Integer[])arr[selected_index]);
			}
		}

		System.out.println(count);
		for(Integer i : selectedIndexArr) {
			System.out.print(i + " ");
		}
		System.out.println();

		for(Integer[] index : selectedArr) {
			System.out.println(index[0] + " " + index[1]);
		}

		/*
		int count = 0;
		int selected_index = 0;

		if(start.length > 0) {
			count++;
			selected_index = 0;
		}

		for(int i = 1; i < finish.length; i++) {
			if(start[i] >= finish[selected_index]) {
				count++;
				selected_index = i;
			}
		}

		System.out.println(count);
		*/
	}
}