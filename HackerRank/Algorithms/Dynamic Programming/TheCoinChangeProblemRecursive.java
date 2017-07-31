// https://www.hackerrank.com/challenges/coin-change

/*
	Time complexity - O(N^N)
*/

class TheCoinChangeProblemRecursive {

	static int count(int[] arr, int num, int sum) {
		// if sum is 0 then do not include any coin
		if (sum == 0)
			return 1;

		// is sum < 0 then no solution exists
		if (sum < 0)
			return 0;

		//if there are no coins and sum is greater then 1 then no solution exists
		if(num <= 0 && sum >= 1)
			return 0;

		// count is sum of solutions that does not contain the mth coin including arr[m-1]
		// summation with those that does not contain arr[m-1]th coin
		return count(arr, num-1, sum) + count(arr, num, sum - arr[num-1]);
	}

	public static void main(String[] args) {

		int arr[] = new int[] {1, 2, 3};
		int m = 4;

		System.out.println(count(arr, arr.length, m));
	}
}