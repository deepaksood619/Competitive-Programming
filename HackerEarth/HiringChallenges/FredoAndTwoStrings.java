import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class FredoAndTwoStrings {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        String t = br.readLine().trim();

        String next = br.readLine().trim();
        String[] nextArr = next.split(" ");
        int q = Integer.parseInt(nextArr[0]);

        for(int z = 0; z < q; z++) {
            String foo = br.readLine().trim();
            String[] fooArr = foo.split(" ");

            int i = Integer.parseInt(fooArr[0]);
            int j = Integer.parseInt(fooArr[1]);

            String check = "";
            int y = 0;
            for(int m = 0; m < i-1 && y < t.length(); m++) {
                if(s.charAt(m) == t.charAt(y)) {
                    y++;
                }
            }
            for(int m = j; m < s.length() && y < t.length(); m++) {
                if(s.charAt(m) == t.charAt(y)) {
                    y++;
                }
            }
            
            if(y == t.length()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
