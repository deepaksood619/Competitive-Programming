// http://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/

/*
	Problem - You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.

	Solution - The greedy choice is to always pick the next activity whose finish time is least among the remaining activities and the start time is more than or equal to the finish time of previously selected activity.

	Algorithmic Approach - Greedy Algorithm

	Assumption - start and finish are sorted according to finish time

	Time Complexity - O(N)
	Space Complexity - O(1)
*/

import java.util.LinkedList;

class ActivitySelectionProblem {

	public static void main(String[] args) {
		int[] start = new int[] {1, 3, 0, 5, 8, 5};
		int[] finish = new int[] {2, 4, 6, 7, 9, 9};
		LinkedList<Integer> indexList = new LinkedList<>();
		LinkedList<StartFinish> activityList = new LinkedList<>();

		int count = 0;
		int last_finish_index = 0;

		if(start.length > 0) {
			count++;
			indexList.add(0);
			activityList.add(new StartFinish(start[0], finish[0]));
		}

		for(int i = 0; i < finish.length; i++) {
			if(start[i] >= finish[last_finish_index]) {
				indexList.add(i);
				activityList.add(new StartFinish(start[i], finish[i]));
				count++;
				last_finish_index = i;
			}
		}

		System.out.println("Num of activities - " + count);
		System.out.print("Index of selected activities - ");
		for(Integer i : indexList) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.print("Start finish of selected activities - ");
		for(StartFinish i : activityList) {
			System.out.print("{ " + i.getStart() + ", " + i.getFinish() + " } ");
		}
	}
}

class StartFinish {
		int start;
		int finish;

		StartFinish(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}

		public int getStart() {
			return this.start;
		}

		public int getFinish() {
			return this.finish;
		}
	}