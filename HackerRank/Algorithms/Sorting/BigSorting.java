// https://www.hackerrank.com/challenges/big-sorting
import java.math.BigInteger;
import java.util.*;

public class BigSorting {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		List<BigInteger> arr = new ArrayList();
		for(int i = 0; i < n; i++) {
			String item = scanner.next();
			BigInteger bigItem = new BigInteger(item);
			arr.add(bigItem);
		}
		
		Collections.sort(arr);
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr.get(i));
		}
		
	}
}
		
		