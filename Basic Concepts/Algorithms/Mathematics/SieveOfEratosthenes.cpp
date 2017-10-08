// http://www.geeksforgeeks.org/sieve-of-eratosthenes/

/*
Time Complexity - O(N log (log N))
Space Complexity - O(n)
*/

#include <iostream>

void printSieve(int n) {
    bool prime[n+1];
    memset(prime, true, sizeof(prime));
        
    for(int i = 2; i <= n; i++)
        if(prime[i])
            for(int j = i+i; j <= n; j+=i)
                prime[j] = false;
    
    for(int i = 2; i <= n; i++)
        if(prime[i])
            std::cout << i << " ";
    
    std::cout << '\n';
}

int main() {
    int n = 0;
    
    std::cin >> n;

    printSieve(n);

    return 0;
}