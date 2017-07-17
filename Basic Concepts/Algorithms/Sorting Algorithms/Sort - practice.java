class SortPractice {
	public static void main(String[] args) {
		System.out.println("Bubble Sort");
		
		int[] arr = new int[] {4, 2, 1, 3};
		
		int n = arr.length;
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
		
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int t = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = t;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
		
	}
}