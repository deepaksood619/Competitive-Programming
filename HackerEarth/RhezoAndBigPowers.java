// https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/practice-problems/algorithm/rhezo-and-big-powers-1/description/

/*
Rhezo likes numbers of the form A^B.

Input:
First line of input contains a single integer A,
Second line contains the integer B

Output:
Help Rhezo find A^B As this number can be large, print it modulo 10^9+7
*/

import java.util.Scanner;
import java.math.BigInteger;

class RhezoAndBigPowers {

	public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        
        BigInteger mod = new BigInteger("1000000007");
        
        BigInteger bigA = in.nextBigInteger();
        BigInteger bigB = in.nextBigInteger();
        BigInteger val = bigA.modPow(bigB, mod);
        
        System.out.println(val);
    }
}