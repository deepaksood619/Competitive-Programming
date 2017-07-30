// https://www.hackerearth.com/codearena/ring/326dc67/

import java.util.*;

class TestClass {
    
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        ArrayList<LinkedList<Integer>> adjList = new ArrayList<>(N);
        
        for(int i = 0; i < N; i++) {
            adjList.add(new LinkedList<Integer>());
        }
        
        int M = in.nextInt();
        
        for(int i = 0; i < M; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            --a;
            --b;
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        for(int i = 0; i < N; i++) {
            System.out.print("i - " + i + " - ");
            for(int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(" " + adjList.get(i).get(j));
            }
            System.out.println();
        }
        
        int sum = 0;
        
        for(int i = 0; i < N; i++) {
            sum += N - adjList.get(i).size() - 1;
        }
        
        System.out.println(sum/2);
    }
}

