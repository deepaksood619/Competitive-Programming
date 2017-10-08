#include <stdio.h>

void palindrome(char *s) {
    // get length of the string
    int i = 0;
    while(s[i] != '\0') {
        i++;
    }
    i--;
    
    // check palindrome
    int j = 0;
    while(j <= i) {
        if(s[i] != s[j]) {
            printf("NO");
            return;
        }
        i--;
        j++;
    }
    printf("YES");
}

int main()
{
    char s[101];
    scanf("%s", s);
    
    palindrome(s);
    
    return 0;
}
