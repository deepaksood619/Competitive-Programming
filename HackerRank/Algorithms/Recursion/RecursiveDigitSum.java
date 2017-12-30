// https://www.hackerrank.com/challenges/recursive-digit-sum/problem

import java.util.Scanner;
import java.math.BigInteger;

class RecursiveDigitSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String inArr[] = input.split(" ");
        int k = Integer.parseInt(inArr[1]);

        StringBuilder sb  = new StringBuilder();
        for(int i = 0; i < k; i++) {
            sb.append(inArr[0]);
        }

        String str = sb.toString();

        System.out.println(superDigit(str));
    }

    static String superDigit(String str) {
        if(str.length() == 1) {
            return str;
        }

        BigInteger val = new BigInteger("0");
        for(int i = 0; i < str.length(); i++) {
            BigInteger newVal = new BigInteger(Character.toString(str.charAt(i)));
            val = val.add(newVal);
        }
        return superDigit(val.toString());
    }
}