// Time Complexity - O(n^2)

class 3SumProblem {

    public static void main(String[] args) {
        int[] arr = new int[] {-25, -10, -7, -3, 0, 4, 8, 25};

        int size = arr.length;

        for (int i = 0; i <= size-3; i++) {
            int sum = arr[i] + arr[i+1];
            int index = binarySearch(arr, i+2, size-1, 0-sum);
            if (index != -1) {
                System.out.println(arr[i] + " " + arr[i+1] + " " + arr[index]);
            }
        }
    }

    public static int binarySearch(int[] arr, int start, int end, int key) {
        if (end >= start) {
            int mid = (start + end) / 2;

            if (arr[mid] == key)
                return mid;
            
            if (key < arr[mid]) {
                return binarySearch(arr, start, mid-1, key);
            }

            return binarySearch(arr, mid+1, end, key);
        }
        return -1;   
    }
}