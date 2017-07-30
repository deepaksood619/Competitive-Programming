// https://www.hackerearth.com/challenge/test/programming-practice-challenge/algorithm/c6f4c9b405004de4937dd5e641b1b2f8/

/* 
Problem Statement - 	
	First line of the input file contains two integers, a and b

	Output:
	Print the number of common factors of a and b.
	1 ≤ a,b ≤ 10^12
	
	naive solution - from i = 2 to min of two numbers find the number that divides both numbers
	- A Naive Solution would be to iterate all the numbers from 1 to n, checking if that number divides n and printing it.
	
	Time Complexity - O(n)
	Space Complexity - O(1)
	
	Correct Solution - 
		1. Find the gcd (maximum value that divide both numbers) of a and b
		2. Find sqrt(gcd(a,b)), since -
			If we look carefully, all the divisors are present in pairs. For example if n = 100, then the various pairs of divisors are: (1,100), (2,50), (4,25), (5,20), (10,10)

			Using this fact we could speed up our program significantly.
			We, however have to careful if there are two equal divisors as in case of (10, 10). In such case we’d print only one of them.
			
			2.1. if integer then Math.sqrt(n) is the sqrt;
			2.2. if big integer then, use the sqrt function 
			
		3. from 1 to sqrt(n), find all the divisors of n, where n = largest divisor;
		4. increment the count by 1 if the divisor is perfect divisible ex - (10, 10), otherwise increment by 2;			
	
	Time Complexity - O(sqrt(n))
	Space Complexity - O(1)
*/

import java.util.Scanner;
import java.math.*;

class LittleShinoAndCommonFactors {
	
	static BigInteger gcd(BigInteger a, BigInteger b) {
		
		if(a.equals(BigInteger.ZERO))
			return b;
		
		return gcd(b.mod(a), a);
		
	}
	
	public static BigInteger sqrt(BigInteger x) {
		BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
		BigInteger div2 = div;
		
		for(;;) {
			BigInteger y = div.add(x.divide(div)).shiftRight(1);
			if (y.equals(div) || y.equals(div2))
				return y;
			div2 = div;
			div = y;
		}
	}
	
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
		
		BigInteger a = new BigInteger(in.next());
		BigInteger b = new BigInteger(in.next());
		
		BigInteger n = gcd(a, b);
        System.out.println(n);
		
        int count = 0;
		BigInteger i = new BigInteger("1");
		BigInteger max = sqrt(n);
		
		while(i.compareTo(max) != 1) {
			
            if(n.mod(i).equals(BigInteger.ZERO)) {
				if(n.divide(i).equals(i)) {
					count++;
				} else {
					count += 2;
				}
            }
			
			i = i.add(BigInteger.ONE);
        }
        
        System.out.println(count);
    }
}