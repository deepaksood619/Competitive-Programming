// https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/crushing-violence/

/*
Max Score - 20
Time Complexity - 
 - for input & for computing - O(2*n)
 - for finding maximum beating - O(2*n) (can be optimized using priority queue)
 - for finding pairs - O(2*n) (can be optimized by using a boolean array with already visited nodes)
*/

import java.util.*;

class CrushingViolence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        while(T-- > 0) {
            int n = in.nextInt();
            int[][] arr = new int[2][n];
            int q1 = 0, q2 = 0;

            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < n; j++) {
                    int input = in.nextInt();
                    arr[i][j] = input - 1;
                }
            }

            ArrayList<Pair> boys = new ArrayList<>(n);
            ArrayList<Pair> girls = new ArrayList<>(n);

            for(int i = 0; i < n; i++) {
                boys.add(new Pair());
                girls.add(new Pair());
            }

            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < n; j++) {
                    int crush = arr[i][j];
                    if(i == 0) {
                        int crushcrush = arr[1][crush];
                        if(crushcrush != j) {
                            // beat
                            boys.get(j).b = crushcrush;
                            boys.get(crushcrush).beat++;
                        }
                    } else {
                        int crushcrush = arr[0][crush];
                        if(crushcrush != j) {
                            girls.get(j).b = crushcrush;
                            girls.get(crushcrush).beat++;
                        }
                    }
                }
            }

            Pair q1boys = Collections.max(boys, new Comparator<Pair>() {
                @Override
                public int compare(Pair a, Pair b) {
                    return Integer.compare(a.beat, b. beat);
                }
            });
            Pair q1girls = Collections.max(girls, new Comparator<Pair>() {
                @Override
                public int compare(Pair a, Pair b) {
                    return Integer.compare(a.beat, b.beat);
                }
            });

            if(q1boys.beat > q1girls.beat) {
                q1 = q1boys.beat;
            } else {
                q1 = q1girls.beat;
            }

            for(int i = 0; i < n; i++) {
                int val = boys.get(i).b;
                
                if (val != -1 && i == boys.get(val).b) {
                    q2++;
                }
            }

            for(int i = 0; i < n; i++) {
                int val = girls.get(i).b;
                if (val != -1 && i == girls.get(val).b) {
                    q2++;
                }
            }

            System.out.println(q1 + " " + q2/2);

        }
    }
}

class Pair {
    int b;
    int beat;

    Pair() {
        b = -1;
        beat = 0;
    }
}