import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class SparseArrays {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine().trim());

        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int q = Integer.parseInt(br.readLine().trim());

        int count;
        for(int i = 0; i < q; i++) {
            count = 0;
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                if(arr[j].equals(input)) {
                    count++;
                }
            }
            System.out.println(count);
        }

        wr.close();
        br.close();
    }

}