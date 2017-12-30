// September Circuits
// Marks - /100
// Test cases passed - 3/91

/*
Using overestimation - Pn < n log (n log n)

3
3 2 1
12025

*/

#include <iostream>
#include <cmath>
#include <vector>
#include <cstring>

const int mod = 1000000007;

void sieve(std::vector<int> &prime, int k) {
    bool arr[k];
    memset(arr, true, sizeof(arr));

    for(int i = 2; i < k; i++) {
        if(arr[i]) {
            for(int j = i+i; j < k; j += i) {
                arr[j] = false;
            }
            prime.push_back(i);
        }
    }
}

long long int divisors(long long int n) {
    long long int p = 1;

    for(int i = 2; i <= n; i++) {
        if(n%i == 0) {
            p = ((p%mod) * i)%mod;
            printf("new p - %lld ,i - %d\n", p, i);
        }
    }

    return p;
}

long long int numDivisors(long long int p) {
    long long int num = 1;

    for(int i = 2; i <= p; i++) {
        if(p%i == 0) {
            num = num + 1;
            printf("num - %lld \n", num);
        }
    }

    return num;
}

int main() {

    int x;
    scanf("%d", &x);

    int arr[x];
    for(int i = 0; i < x; i++) {
        scanf("%d", &arr[i]);
    }

    int k = 6;
    if(x >= 6) {
        k = x * log ( x * log(x));
    }
    // printf("k - %d\n", k);

    std::vector<int> prime;
    
    sieve(prime, k);

    // printf("size - %lu\n", prime.size());
    // for(std::vector<int>::iterator i = prime.begin(); i != prime.end(); i++) {
        // std::cout << *i << " ";
    // }

    // printf("size - %lu\n", prime.size());

    long long int n = 1;
    for(int i = 0; i < x; i++) {
        n = ((n%mod) * ((long long int)pow(prime.at(i), arr[i])%mod))%mod;
    }

    printf("n - %lld\n", n);
    long long int p = divisors(n);
    printf("divisors - %lld\n", p);

    long long int num = numDivisors(p);
    num = num%mod;
    printf("%lld", num);

    return 0;
}