// approximate problem

/*
4 2 5
10 51 45 24
50 77 98 12
23 62 33 65
89 41 36 78
17 23 76 54
40 50 10 30

4 3 5
10 51 45 24
50 77 98 12
23 62 33 65
89 41 36 78
17 23 76 54
40 50 10 30
*/

#include <iostream>

int* solve(int n, int m, int k, int* clients, int facilityCost[]) {
    int* ans = new int[k];

    for(int i = 0; i <= n-k; i++) {
        for(int j = i+k-1; j <= n-1; j++) {
            
            printf("%d %d, ", i, j);
        }
        printf("\n");
    }

    for(int i = 0; i < k; i++) {
        ans[i] = i;
    }

    return ans;
}

int main() {
    int n, k, m;

    scanf("%d %d %d", &n, &k, &m);
    int clients[m][n];

    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            scanf("%d", &clients[i][j]);

        }
    }

    int facilityCost[n];
    for(int i = 0; i < n; i++) {
        scanf("%d", &facilityCost[i]);
    }

    int* ans;
    ans = solve(n, m, k, (int *)clients, facilityCost);

    for(int i = 0; i < k; i++) {
        printf("%d ", *(ans+i));
    }
    printf("\n");

    return 0;
}