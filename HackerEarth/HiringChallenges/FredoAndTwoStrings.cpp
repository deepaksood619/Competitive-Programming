#include <iostream>
#include <cstring>

using namespace std;

int main() {

    ios::sync_with_stdio(0);
    cin.tie(0);

    char s[10005], t[10005];

    cin >> s >> t;
    
    int q, blank;

    cin >> q >> blank;

    int i, j;
    int y;
    for(int z = 0; z < q; z++) {
        cin >> i >> j;
        y = 0;
        for(int m = 0; m < i-1 && y < strlen(t); m++) {
            if(s[m] == t[y]) {
                y++;
            }
        }
        for(int m = j; m < strlen(s) && y < strlen(t); m++) {
            if(s[m] == t[y]) {
                y++;
            }
        }

        if(y == strlen(t)) {
            cout << "Yes\n";
        } else {
            cout << "No\n";
        }
    }


    return 0;
}
