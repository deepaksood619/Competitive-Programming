#include <stdio.h>
#include <stdbool.h>
#include <strings.h>

void sieve(int n) {
    bool prime[n+1];
    memset(prime, true, n+1);

    for(int i = 2; i <= n; i++) {
        if(prime[i]) {
            for(int j = i+i; j <= n; j += i) {
                prime[j] = false;
            }
            printf("%d ", i);
        }
    }
}

int main() {

    int n;
    scanf("%d", &n);

    sieve(n);

    return 0;
}