#include <stdio.h>

const int MOD = 1000000007;

int main() {

    int n;
    scanf("%d", &n);

    int val = 0;
    long int product = 1;
    for(int i = 0; i < n; i++) {
        scanf("%d", &val);
        product = (product * val)%MOD;
    }
    printf("%ld", product);

    return 0;
}