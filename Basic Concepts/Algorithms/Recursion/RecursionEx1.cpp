#include<stdio.h>
 
void abc(char *s)
{
    if(s[0] == '\0')
        return;
 
    abc(s + 1);
    abc(s + 1);
    printf("%c", s[0]);
}
 
int main()
{
    abc("xyz");
    return 0;
}