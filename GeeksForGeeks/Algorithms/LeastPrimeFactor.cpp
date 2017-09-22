// http://practice.geeksforgeeks.org/problems/least-prime-factor/0

// http://www.geeksforgeeks.org/least-prime-factor-of-numbers-till-n/

#include <iostream>
// for memset
#include <cstring>

void modifiedSieve(int leastPrimeFactor[], int max) {
    leastPrimeFactor[1] = 1;

    for(int i = 2; i <= max; i++) {
        if(leastPrimeFactor[i] == 0) {
            leastPrimeFactor[i] = i;
            for(int j = i+i; j <= max; j += i) {
                if(leastPrimeFactor[j] == 0)
                    leastPrimeFactor[j] = i;
            }
        }
    }
}

int main() {
    int t;

    scanf("%d", &t);

    int arr[t];
    int max = 0;
    for(int i = 0; i < t; i++) {
        scanf("%d", &arr[i]);
        if(arr[i] > max) {
            max = arr[i];
        }
    }

    int leastPrimeFactor[max+1];
    memset(leastPrimeFactor, 0, sizeof(leastPrimeFactor));

    modifiedSieve(leastPrimeFactor, max);

    for(int i = 0; i < t; i++) {
        for(int j = 1; j <= arr[i]; j++) {
            printf("%d ", leastPrimeFactor[j]);
        }
        printf("\n");
    }

    return 0;
}