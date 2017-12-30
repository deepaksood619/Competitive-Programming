import java.util.*;
import java.math.*;

class KDevices {
    
    static int max(int i, int j) {
        if(i <= j) {
            return i;
        } else {
            return j;
        }
    }
    
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        
        /*
        int N = in.nextInt();
        int K = in.nextInt();
        
        int[] X = new int[N];
        int[] Y = new int[N];
        for(int i = 0; i <N; i++) {
            X[i] = in.nextInt();
        }
        for(int j = 0; j < N; j++) {
            Y[j] = in.nextInt();
        }
        
        

        */
        int N = 4;
        int K = 4;
        int X[] = new int[]{1, -1, 1, -2};
        int Y[] = new int[]{1, -1, 1, -1};
        
        System.out.println("hello");

        int[] dist = new int[N];
        for(int i = 0; i < N; i++) {
            dist[i] = max(Math.abs(X[i]), Math.abs(Y[i]));
        }

        
        Arrays.sort(dist);

        for(int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
        
        int count = 0;
        int level = 0;
        for(int i = 0; i < N; i++) {
            if(count < K) {
                
                count++;
            } 
            if(count == K) {
                System.out.println(dist[i] + " i - " + i);
                level = dist[i];
                break;
            }
        }
        
        System.out.println(level);
        level += 1;
        System.out.println(level);
        
    }
}
