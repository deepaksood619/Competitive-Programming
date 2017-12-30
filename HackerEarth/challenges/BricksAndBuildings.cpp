#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int buildings[n];

    for(int i = 0; i < n; i++) {
        scanf("%d", &buildings[i]);
    }

    // eliminate duplicate buildings % operation
    int buildingCount[100009];
    for(int i = 0; i < 100009; i++)
        buildingCount[i] = 0;

    for(int i = 0; i < n; i++) {
        buildingCount[buildings[i]]++;
    }

    int q;
    scanf("%d", &q);

    // save answer to the query k in array, 
    // if already solved then return the answer
    int ans[100009];
    for(int i = 0; i < 100009; i++)
        ans[i] = -1;

    for(int i = 0; i < q; i++) {
        int k;
        scanf("%d", &k);

        if(ans[k] == -1) {
            int count = 0;
            for(int i = 0; i <= 100000; i++) {
                if(i%k == 0) {
                    count += buildingCount[i];
                }
            }
            ans[k] = count;
        }
        
        printf("%d\n", ans[k]);
    }

    return 0;
}