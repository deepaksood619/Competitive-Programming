// National Instruments Hiring
// Marks - 54/100
// Test cases passed - 21/24

#include <iostream>
#include <stack>

int main() {

    int t;
    std::cin >> t;

    while(t-- > 0) {
        int n, k;
        std::cin >> n >> k;

        char matrix[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                std::cin >> matrix[i][j];
            }
        }

        /*int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 'P') {
                    // check k left starting from farthest to maximize
                    bool leftFlag = true;
                    for(int m = k; m >= 1; m--) {
                        if(j-m >= 0 && matrix[i][j-m] == 'T') {
                            matrix[i][j-m] = 'X';
                            matrix[i][j] = 'Y';
                            count++;
                            leftFlag = false;
                            break;
                        }
                    }

                    // check k right starting from nearest to maximize
                    if(leftFlag) {
                        for(int m = 1; m <= k; m++) {
                            if(j+m < n && matrix[i][j+m] == 'T') {
                                matrix[i][j+m] = 'X';
                                matrix[i][j] = 'Y';
                                count++;
                                break;
                            }
                        }
                    }
                }
            }
        }*/

        stack <int> holder;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                
            }
        }

        std::cout << count << '\n';
    }

    return 0;
}