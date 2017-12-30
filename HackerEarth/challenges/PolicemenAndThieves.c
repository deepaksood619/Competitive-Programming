#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

int solution (char** matrix, int k, int n) {
    int count = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(matrix[i][j] == 'P') {
                // check k left starting from farthest to maximize
                bool leftFlag = true;
                for(int m = k; m >= 1; m--) {
                    if(j-m >= 0 && matrix[i][j-m] == 'T') {
                        matrix[i][j-m] = 'X';
                        matrix[i][j] = 'Y';
                        count++;
                        leftFlag = false;
                        break;
                    }
                }

                // check k right starting from nearest to maximize
                if(leftFlag) {
                    for(int m = 1; m <= k; m++) {
                        if(j+m < n && matrix[i][j+m] == 'T') {
                            matrix[i][j+m] = 'X';
                            matrix[i][j] = 'Y';
                            count++;
                            break;
                        }
                    }
                }
            }
        }
    }
    return count;
}

int main() {
    int T;
    scanf("%d", &T);
    for(int t_i=0; t_i<T; t_i++)
    {
        int N;
        scanf("%d", &N);
        int K;
        scanf("%d", &K);
        int i_A, j_A;
        char **A = (char **)malloc(N*sizeof(char *));
        for(i_A=0; i_A<N; i_A++)
        {
        	A[i_A] = (char *)malloc(N*sizeof(char));
        }
        for(i_A=0; i_A<N; i_A++)
        {
        	for(j_A=0; j_A<N; j_A++)
        	{
        		scanf(" %c", &A[i_A][j_A]);
        	}
        }
        

        int out_ = solution(A, K, N);
        printf("%d", out_);
        printf("\n");
    }
}