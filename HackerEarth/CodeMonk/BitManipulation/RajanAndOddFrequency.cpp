#include <iostream>
#include <cstring>

using namespace std;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    int num = 2*n + 1;
    int arr[num];
    int max = 0;
    int val;

    // input all numbers and calculate max for creating the count array
    for(int i = 0; i < num; i++) {
        cin >> val;
        arr[i] = val;
        if(val > max) {
            max = val;
        }
    }

    int count[max+1];
    memset(count, 0, (max+1)*sizeof(int));

    // counting all the occurences of number
    for(int i = 0; i < num; i++) {
        count[arr[i]]++;
    }

    // finding the odd occurence and stopping when found
    for(int i = 0; i < num; i++) {
        if(count[i]%2 != 0) {
            cout << i;
            break;
        }
    }

    return 0;
}