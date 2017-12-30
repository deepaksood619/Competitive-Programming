#include <iostream>
#include <cmath>

void printSieve(int n) {
    bool prime[n+1];
    memset(prime, true, sizeof(prime));

    for(int i = 2; i <= n; i++) {
        if(prime[i]) {
            for(int j = i+i; j <= n; j += i) {
                prime[j] = false;
            }
        }
    }

    for(int i = 2; i <= n; i++) {
        if(prime[i])
            printf("%d ", i);
    }
}

int main() {
    int n;
    scanf("%d", &n);

    printSieve(n);
}