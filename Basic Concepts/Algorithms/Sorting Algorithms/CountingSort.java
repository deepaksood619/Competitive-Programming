// only sorts the 1 digit numbers

class CountingSort {
	public static void main(String[] args) {
		System.out.println("CountingSort");
		int[] arr = new int[] {4, 2, 1, 3, 1, 5,6,7,8,9,1,0,2,3,4,5,6,6};
		
		int n = arr.length;
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
		
		int[] indexArr = new int[10];
		
		for(int i = 0; i < n; i++) {
			int index = arr[i] % 10;
			indexArr[index]++;
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < indexArr[i]; j++) {
				System.out.println(i);
			}
		}
	}
}