// https://www.codechef.com/SEPT17/problems/SEACO
// Problem Code - SEACO

/*
1st test case solved
2nd test case - WA
3rd test case - TLE
*/

import java.util.*;

class SerejaAndCommands {

	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		while(T-- > 0) {
            
            int n = in.nextInt();
            int m = in.nextInt();

            Solve solve = new Solve(n, m);

            for( int i = 0; i < m; i++ ) {
                int t = in.nextInt();
                int l = in.nextInt();
                int r = in.nextInt();
                --l;
                --r;

                solve.addCommand(t, l, r);
            }

            solve.runCommands(0, m-1);

            solve.print();

		}
		
		in.close();
    }
    
    static void inc(int[] arr, int l, int r) {
        for(int i = l; i <= r; i++) {
            arr[i]++;
        }
    }
}

class Solve {
    // size of arr
    int n;

    // num of commands
    int m;

    int[] arr;
    ArrayList<Command> commands;
    int[] lastSnapshot;

    Solve(int n, int m) {
        this.n = n;
        this.m = m;
        arr = new int[n];
        commands = new ArrayList<>(m);
        lastSnapshot = new int[n];
    }

    public void addCommand(int t, int l, int r) {
        commands.add(new Command(t, l, r, n));
    }

    public void runCommands(int l, int r) {
        for(int i = l; i <= r; i++) {
            Command comm = commands.get(i);
            if(comm.t == 1) {
                inc(comm.l, comm.r, 1);
            } else {
                if(!comm.init) {
                    System.arraycopy(arr, 0, lastSnapshot, 0, n);
                    runCommands(comm.l, comm.r);
                    comm.init = true;
                    for(int k = 0; k < n; k++) {
                        comm.add[k] = arr[k] - lastSnapshot[k];
                    }

                } else {
                    for(int k = 0; k < n; k++) {
                        arr[k] += comm.add[k];
                    }
                }
            }
        }
    }

    public void inc(int l, int r, int add) {
        for(int i = l; i <= r; i++) {
            arr[i] += add;
        }
    }

    public void print() {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class Command {
    int t;
    int l;
    int r;
    int n;
    int[] add;
    boolean init;

    Command(int t, int l, int r, int n) {
        this.t = t;
        this.l = l;
        this.r = r;
        this.n = n;
        if(t == 2) {
            add = new int[n];
        }
        init = false;
    }
}