// https://www.hackerearth.com/codearena/ring/d58bbe2/

/*
Problem Statement - 
Limak is an old brown bear. He often goes bowling with his friends.

For rolling a ball one gets a score - a non-negative integer number of points. Score for the i-th roll is multiplied by i and scores are summed up. For example, for rolls with scores 7, 10, 5 the total score is equal to 7×1 + 10×2 + 5×3 = 42.

Limak made N rolls and got a score Ai for the i-th of them.

Unfortunately, the bowling club's computer system isn't stable today. Any rolls can be erased! Then, the total score is calculated as if there were only non-erased rolls. There are 2N possible sequences of remaining (non-erased) rolls. Limak is curious about various statistics of this situation.

He asks you for one thing. Find the sum of total scores of all 2N possible sequences of remaining rolls. Print it modulo 109+7.

Input format

The first line contains a single integer N.

The second line contains N non-negative integers A1, A2, ..., AN.

Output format

In a single line print modulo 109+7 the sum of total scores of possible remaining sequences.

Constraints

1 ≤ N ≤ 200,000
0 ≤ Ai ≤ 109


Test case -
3
6 12 8

Solution - 160
*/

import java.util.Scanner;
import java.math.BigInteger;

class SumOfSubsets {
    public static void main(String args[] ) throws Exception {
		
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        
        BigInteger sum = new BigInteger("0");
		BigInteger modVal = new BigInteger("1000000007");
        
        for(int i = 0; i < (1<<N); i++) {
			int rolNum = 0;
            for(int j = 0; j < N; j++) {
                if((i & (1 << j)) > 0) {
					
					rolNum++;
					BigInteger rolNumBig = BigInteger.valueOf(rolNum);
					BigInteger arrValBig = BigInteger.valueOf(arr[j]);
					
					sum = sum.add(rolNumBig.multiply(arrValBig));
                }
            }
        }
        
		sum = sum.mod(modVal);
		
		System.out.println(sum);
		
    }
}
