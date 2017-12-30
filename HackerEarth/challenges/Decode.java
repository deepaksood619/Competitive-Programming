import java.util.Scanner;

class Decode {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String test = in.nextLine();

        int t = Integer.parseInt(test);

        while(t-- > 0) {
            String enc = in.nextLine();
            decode(enc);
        }
    }

    static void decode(String enc) {
        int len = enc.length();

        StringBuilder sb = new StringBuilder(enc);

        int j = (len-1)/2;
        // for flipping between +x and -x
        boolean flag = true;
        int count = 1;

        if(len != 0) {
            sb.setCharAt(j, enc.charAt(0));
        }

        if(len%2 == 0) {
            // even

            for(int i = 1; i < len; i++) {
                if(flag) {
                    flag = false;
                    int val = j+count;
                    sb.setCharAt(val, enc.charAt(i));
                } else {
                    flag = true;
                    int val = j-count;
                    sb.setCharAt(val, enc.charAt(i));
                    count++;
                }
            }

        } else {
            // odd

            for(int i = 1; i < len; i++) {
                if(flag) {
                    flag = false;
                    sb.setCharAt(j-count, enc.charAt(i));
                } else {
                    flag = true;
                    sb.setCharAt(j+count, enc.charAt(i));
                    count++;
                }
            }
        }

        System.out.println(sb.toString());

    }

}