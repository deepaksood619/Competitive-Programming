// http://www.geeksforgeeks.org/quick-sort/

/*
Like Merge Sort, QuickSort is a Divide and Conquer algorithm. 
It picks an element as pivot and partitions the given array around the picked pivot.

The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as pivot, 
put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, 
and put all greater elements (greater than x) after x. 
All this should be done in linear time.

Pseudo Code for recursive QuickSort function :

//low  --> Starting index,  high  --> Ending index
quickSort(arr[], low, high)
{
    if (low < high)
    {
        // pi is partitioning index, arr[p] is now at right place
        pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);  // Before pi
        quickSort(arr, pi + 1, high); // After pi
    }
}

Time Complexity - O(N*log(N))
Space Complexity - O(1)
In-place - yes
Stable - yes

*/

class QuickSort {

	/*
	we start from the leftmost element and keep track of index of smaller (or equal to) elements as i. While traversing, if we find a smaller element, we swap current element with arr[i]. Otherwise we ignore current element.
	*/
	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];

		int i = low - 1;

		for(int j = low; j <= high-1; j++) {
			if(arr[j] <= pivot) {
				i++;
				// swap( arr[i], arr[j] );
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap( arr[i+1], arr[high] );
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

	public static void main(String[] args) {
		int[] arr = new int[] {3, 2, 1, 4};

		quickSort(arr, 0, arr.length - 1);

		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}