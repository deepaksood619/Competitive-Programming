// http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/

#include <stdio.h>
#include <algorithm>

void combinationUtil(int*, int*, int, int, int, int);

void printCombinations(int arr[], int n, int r) {
    int data[r];

    // to handle duplicates
    std::sort(arr, arr+n);

    combinationUtil(arr, data, 0, n-1, 0, r);
}

void combinationUtil(int arr[], int data[], int start, int end, int index, int r) {
    if(index == r) {
        for(int i = 0; i < r; i++) {
            printf("%d ", data[i]);
        }
        printf("\n");
        return;
    }

    for(int i = start; i <= end && end-i+1 >= r-index; i++) {
        data[index] = arr[i];
        combinationUtil(arr, data, i+1, end, index+1, r);

        // to handle duplicates
        while(arr[i] == arr[i+1])
            i++;
    }
}

int main() {
    int arr[] = {1, 2, 1};

    int r = 2;

    int n = sizeof(arr)/sizeof(arr[0]);

    printCombinations(arr, n, r);

    return 0;
}