// http://practice.geeksforgeeks.org/problems/largest-prime-factor/0

#include <stdio.h>
#include <math.h>

int largestFactor(int n) {
    int largest = 0;
    
    while(n%2 == 0) {
        n /= 2;
        largest = 2;
    }
    
    for(int i = 3; i <= sqrt(n); i += 2) {
        while(n%i == 0) {
            n /= i;
            largest = i;
        }
    }
    
    if(n > 2) {
        largest = n;
    }
    
    return largest;
}

int main() {

    int t;

    scanf("%d", &t);

    int val = 0;

    for(int i = 0; i < t; i++) {
        scanf("%d", &val);
        printf("%d\n", largestFactor(val));
    }

    return 0;
}