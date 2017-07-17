// http://practice.geeksforgeeks.org/problems/x-total-shapes/0


/*
1
3 7
OOOXOOO
OXXXXXO
OXOOOXO
*/
import java.util.Scanner;

class XTotalShapes {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		while(T-- > 0) {
			int N = in.nextInt();
			int M = in.nextInt();
			
			String[] arr = new String[N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = in.next();
			}
			
			/*for(int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();*/
			
			boolean[][] visited = new boolean[N][M];
			
			int count = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					//System.out.println("out i - " + i + "out j - " + j);
					if(arr[i].charAt(j) == 'X' && !visited[i][j]) {
						count++;
						//System.out.println("in i - " + i + " in j - " + j);
						markConnectedX(arr, visited, i, j, N, M);
					}
				}
			}
			
			System.out.println(count);
			
			/*System.out.println();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					System.out.print(visited[i][j] + " ");
				}
				System.out.println();
			}
			*/
		}
	}
	
	static void markConnectedX(String[] arr, boolean[][] visited, int i, int j, int N, int M) {
		//System.out.println("i - " + i + " j - " + j);
		if(arr[i].charAt(j) == 'X' && !visited[i][j]) {
			visited[i][j] = true;
		
		if(i + 1 < N)
			markConnectedX(arr, visited, i+1, j, N, M);
		
		if(i - 1 >= 0)
			markConnectedX(arr, visited, i-1, j, N, M);
		
		if(j + 1 < M)
			markConnectedX(arr, visited, i, j+1, N, M);
		
		if(j - 1 >= 0)
			markConnectedX(arr, visited, i, j-1, N, M);
		}
	}
	
}