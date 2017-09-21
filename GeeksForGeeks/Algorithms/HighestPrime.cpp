// http://www.geeksforgeeks.org/find-highest-occurring-digit-prime-numbers-range/
// http://practice.geeksforgeeks.org/problems/find-the-highest-occurring-digit-in-prime-numbers-in-a-range/0

#include <iostream>

void sieve(bool prime[], int r) {
    for(int i = 2; i*i <= r; i++) {
        if(prime[i])
            for(int j = i+i; j <= r; j += i)
                prime[j] = false;
    }
}

int maxDigitInRange(bool prime[], int l, int r) {
    
    int freq[10] = {0};
    
    for(int i = l; i <= r; i++)
        if(prime[i]) {
            int p = i;
            while(p) {
                freq[p%10]++;
                p /= 10;
            }
        }

    int max = freq[0];
    int ans = -1;

    for (int i = 0; i <= 9; i++) {
        if(freq[i] != 0 && freq[i] >= max) {
            max = freq[i];
            ans = i;
        }
    }

    return ans;
}

int main() {
	int t;
	
    std::cin >> t;
    
    int maxR = 0;
    int arr[t][2];
    for(int i = 0; i < t; i++) {
        std::cin >> arr[i][0] >> arr[i][1];

        if(arr[i][1] > maxR) {
            maxR = arr[i][1];
        }
    }

    bool prime[maxR+1];
    memset(prime, true, sizeof(prime));
    sieve(prime, maxR);

    for(int i = 0; i < t; i++) {
        int result = maxDigitInRange(prime, arr[i][0], arr[i][1]);
        std::cout << result << '\n';
    }

	return 0;
}