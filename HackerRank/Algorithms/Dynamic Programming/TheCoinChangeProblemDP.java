// https://www.hackerrank.com/challenges/coin-change

/*
Dynamic Programming Problem -
1. Overlapping Subproblem
2. Optimal Substructure

Storing Values -
1. Memoization (Top Down)
2. Tabulation (Bottom Up)

Time Complexity - O(M*N)
Space Complexity - O(N)
*/

class TheCoinChangeProblemDP {

	static int count(int[] arr, int num, int sum) {

		int[] table = new int[sum+1];

		table[0] = 1;

		for(int i = 0; i < num; i++) {
			for(int j = arr[i]; j <= sum; j++) {
				table[j] += table[j - arr[i]];
			}
		}

		return table[sum];
	}

	public static void main(String[] args) {

		int arr[] = new int[] {1, 2, 3};
		int m = 4;

		System.out.println(count(arr, arr.length, m));
	}
}