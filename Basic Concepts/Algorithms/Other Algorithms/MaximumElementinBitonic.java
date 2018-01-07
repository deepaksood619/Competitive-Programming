// Time Complexity - O(log n) using binary search

class MaximumElementinBitonic {

    public static int findMaximum(int[] arr, int low, int high) {

        // if only one element is present in arr
        if (low == high)
            return arr[low];

        /* If there are two elements and 
          first is greater then the first 
          element is maximum */
       if ((high == low + 1) && arr[low] >= arr[high])
          return arr[low];
      
       /* If there are two elements and 
          second is greater then the second 
          element is maximum */
       if ((high == low + 1) && arr[low] < arr[high])
          return arr[high];

        /* low + (high - low)/2; for preventing integer overflow for large numbers */
       int mid = (low + high)/2;   
      
       /* If we reach a point where arr[mid] 
          is greater than both of its adjacent 
          elements arr[mid-1] and arr[mid+1], 
          then arr[mid] is the maximum element*/
       if ( arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
          return arr[mid];
      
       /* If arr[mid] is greater than the next 
          element and smaller than the previous 
          element then maximum lies on left side 
          of mid */
       if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])
         return findMaximum(arr, low, mid-1);
       else
         return findMaximum(arr, mid + 1, high);

    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 50, 10, 9, 7, 6};
        int n = arr.length;
        System.out.println("The maximum element is "+ 
                            findMaximum(arr, 0, n-1));
    }
}