#include <iostream>

void printSubset(char arr[], int n) {
    for(int i = 0; i < (1<<n); i++) {
        for(int j = 0; j < n; j++) {
            // if jth bit is set then print arr[j]
            if(i & (1 << j)) {
                // not 0 means jth bit is set
                std::cout << arr[j] << " ";
            }
        }
        std::cout << '\n';
    }
}

int main() {

    char arr[] = {'a', 'b', 'c', 'd'};

    printSubset(arr, 4);

    return 0;
}