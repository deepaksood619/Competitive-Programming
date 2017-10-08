#include <stdio.h>

void showStats(int n) {
    switch(n%12) {
        case 0:
            printf("%d ", n-11);
            break;
        case 1:
            printf("%d ", n+11);
            break;
        case 2:
            printf("%d ", n+9);
            break;
        case 3:
            printf("%d ", n+7);
            break;
        case 4:
            printf("%d ", n+5);
            break;
        case 5:
            printf("%d ", n+3);
            break;
        case 6:
            printf("%d ", n+1);
            break;
        case 7:
            printf("%d ", n-1);
            break;
        case 8:
            printf("%d ", n-3);
            break;
        case 9:
            printf("%d ", n-5);
            break;
        case 10:
            printf("%d ", n-7);
            break;
        case 11:
            printf("%d ", n-9);
            break;
    }

    switch(n%6) {
        case 0:
        case 1:
            printf("WS\n");
            break;
        case 2:
        case 5:
            printf("MS\n");
            break;
        case 3:
        case 4:
            printf("AS\n");
            break;
    }
}

int main() {

    int t;
    scanf("%d", &t);

    int n;
    while(t-- > 0) {
        scanf("%d", &n);

        showStats(n);
    }

    return 0;
}