// https://www.hackerrank.com/challenges/the-power-sum/problem

import java.util.*;

class ThePowerSum {

    static int numOfSolutions;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int X = in.nextInt();
        int N = in.nextInt();

        powerSum(X, N, 0, 1);
        System.out.println(numOfSolutions);
    }

    static void powerSum(int X, int N, int currSum, int currNum) {
        if(currSum == X) {
            numOfSolutions++;
            return;
        }

        for(int i = currNum; (currSum + (int) Math.pow(i, N)) <= X; i++) {
            powerSum(X, N, currSum + (int) Math.pow(i, N), i+1);
        }
    }

}