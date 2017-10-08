/*
0-9 - 48-57
A-Z - 65-90
a-z - 97-122
*/

#include <stdio.h>
#include <stdlib.h>
#include <strings.h>

int main() {

int t, i, diff;
scanf("%d", &t);

while(t-- > 0) {

    char a[10001], b[10001];
    scanf("%s %s", a, b);

    int countA[26] = {0};
    int countB[26] = {0};

    for(i = 0; i < strlen(a); i++) {
        countA[a[i]-97]++;
    }

    for(i = 0; i < strlen(b); i++) {
        countB[b[i]-97]++;
    }

    diff = 0;
    for(i = 0; i < 26; i++) {
        diff += abs(countA[i] - countB[i]);
    }

    printf("%d\n", diff);
}
    return 0;
}