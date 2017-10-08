/*
0-9 - 48-57
A-Z - 65-90 (67, 71, 73, 79, 83, 89)
a-z - 97-122 (97, 101, 103, 107, 109, 113, 127)
*/

#include <stdio.h>

int main() {

    int t;
    scanf("%d", &t);

    int s;
    char ch;
    while(t-- > 0) {
        scanf("%d", &s);
        getchar();

        for(int i = 0; i < s; i++) {
            ch = getchar();

            int val = 0;

            if(ch <= 69) {
                val = 67;
            } else if(ch <= 72) {
                val = 71;
            } else if(ch <= 76) {
                val = 73;
            } else if(ch <= 81) {
                val = 79;
            } else if(ch <= 86) {
                val = 83;
            } else if(ch <= 93) {
                val = 89;
            } else if(ch <= 99) {
                val = 97;
            } else if(ch <= 102) {
                val = 101;
            } else if(ch <= 105) {
                val = 103;
            } else if(ch <= 108) {
                val = 107;
            } else if(ch <= 111) {
                val = 109;
            } else {
                val = 113;
            }

            printf("%c", val);
        }
        printf("\n");
    }

    return 0;
}