// http://practice.geeksforgeeks.org/problems/check-for-subsequence/0

#include <iostream>

using namespace std;

int main() {

    ios::sync_with_stdio(0);
    cin.tie(0);

    int T;
    cin >> T;

    char a[1005], b[1005];
    int i, j = 0;
    while(T-- > 0) {

        j = 0;

        cin >> a >> b;

        for(i = 0; i < strlen(b) && j < strlen(a); i++) {
            if(a[j] == b[i]) {
                j++;
            }
        }

        cout << (j == strlen(a)) << "\n";

    }

    return 0;
}