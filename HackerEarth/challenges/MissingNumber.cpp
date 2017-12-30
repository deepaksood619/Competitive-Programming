// National Instruments Hiring
// Marks - 100/100
// Test cases passed - 6/6

#include <stdio.h>
#include <algorithm>

int main() {
    int t;
    scanf("%d", &t);

    while(t-- > 0) {
        int n;
        scanf("%d", &n);

        int arr[n];
        
        for(int i = 0; i < n; i++) {
            scanf("%d", &arr[i]);
        }

        std::sort(arr, arr+n);

        int max = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] > max) {
                if(arr[i]%2 == 1) {
                    if(arr[i]-1 > max) {
                        max += 2;
                    }
                } else {
                    max += 2;
                }
            }
        }

        printf("%d\n", max+2);

    }
    return 0;
}