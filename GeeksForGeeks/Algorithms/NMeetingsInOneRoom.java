// http://practice.geeksforgeeks.org/problems/n-meetings-in-one-room/0

/*
Thought process -
Since after sorting the index of the meetings changes, an array with meetings index is saved so that it can be used to give the index of meetings.

The meetings are sorted in ascending order according to there finish time, if next meeting has a start time greater than or equal to the previous finish time, the meeting is selected.
Greedy approach is used to get the most optimal solution at that time.

Algorithmic Approach - Greedy Algorithm

Time Complexity - O(N*log(N))
Space Complexity - O(N) - extra space for storing index of the meetings

*/

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class NMeetingsInOneRoom {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int T = in.nextInt();
	    
	    while(T-- > 0) {
	        int N = in.nextInt();
	        
	        int[][] arr = new int[N][3];
	        
	        for(int i = 0; i < N; i++) {
	            arr[i][2] = i+1;
	        }
	        
	        for(int i = 0; i < 2; i++) {
	            for(int j = 0; j < N; j++) {
	                int k = in.nextInt();
	                arr[j][i] = k;
	            }
	        }
	        
	        Arrays.sort(arr, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] a, int[] b) {
	                return Integer.compare(a[1], b[1]);
	            }
	        });
	        
	        int count = 0;
	        int selected_index = 0;
	        if(arr.length > 0) {
	            count++;
	            System.out.print(arr[selected_index][2] + " ");
	        }
	        
	        for(int i = 1; i < arr.length; i++) {
	            if(arr[i][0] >= arr[selected_index][1]) {
	                count++;
	                selected_index = i;
	                System.out.print(arr[selected_index][2] + " ");
	            }
	        }
	        
	        System.out.println();
	    }
	}
}