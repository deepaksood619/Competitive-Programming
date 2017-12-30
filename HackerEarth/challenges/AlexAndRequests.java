//https://www.hackerearth.com/challenge/hiring/bima-java-hiring-challenge/problems/6dfbf24fb7d842158e1e0e68d2b260c6/

/*
Alex and Requests
Alex is working in a firm, where he needs to process requests according to their priority. He has 
N
N allocation systems. At any instance, 
i
t
h
ith system can process only one request with priority 
i
i or above.

For each request, on any eligible system, Alex can also terminate the request with less priority than that of the current request, in order to assign the current request to the system. There will be 
Q
Q incoming requests and he needs to tell whether he can assign a system to each request or not.

Alex needs to assign each request to the system optimally, such that he can assign maximum number of incoming requests. The number of requests (which are already assigned) terminated by Alex, doesn't matter here.

Note:
If not terminated explicitly, consider the processing time of every request as infinite.

Input Format:

First line of the input contains 
N
N, denoting the number of allocation systems.

Next line contains one integer 
Q
Q, which denotes the number of incoming requests.

In next 
Q
Q lines, each line contains one integer 
X
X, denoting the priority of the request.

Output Format:

For each incoming request, in new line print 
Y
E
S
YES, if Alex can assign a system to the request, else print 
N
O
NO .
*/

import java.util.Scanner;

class AlexAndRequests {
    public static void main(String args[] ) throws Exception {
        
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        int[] allocationArr = new int[N+1];
        
        int Q = in.nextInt();
        
        for(int i = 0; i < Q; i++) {
            
            int request = in.nextInt();
			
			boolean allocated = false;
            
            if(request >= N) {
                if(allocationArr[N] < request) {
                    allocationArr[N] = request;
                    allocated = true;
                } else {
                    for(int j = N-1; j >= 1; j--) {
                        if(allocationArr[j] < request) {
                            allocationArr[j] = request;
                            allocated = true;
							break;
                        }
                    }
                }
            } else {
				if(allocationArr[request] < request) {
					allocationArr[request] = request;
					allocated = true;
				} else {
					for(int j = request; j >= 1; j--) {
						if(allocationArr[j] < request) {
                            allocationArr[j] = request;
                            allocated = true;
							break;
                        }
					}
				}
			}		

            String out = allocated ? "YES" : "NO";
            System.out.println(out);
        }
        
    }
}
