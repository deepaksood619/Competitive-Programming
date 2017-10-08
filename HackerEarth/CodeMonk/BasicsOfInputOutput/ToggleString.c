//

/*
0-9 - 48-57
A-Z - 65-90
a-z - 97-122
*/

#include <stdio.h>

int main()
{
    char s[101];
    
    scanf("%s", s);
    
    int i = 0;
    
    while(s[i] != '\0') {
        if(s[i] >= 65 && s[i] <=90) {
            // capital
            s[i] += 32;
        } else {
            // small
            s[i] -= 32;
        }
        i++;
    }

    printf("%s", s);
    
    return 0;
}
