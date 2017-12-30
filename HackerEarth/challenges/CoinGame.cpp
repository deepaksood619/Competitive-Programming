
#include <stdio.h>

int main()
{
    int t;
    scanf("%d", &t);
    
    while(t-- > 0) {
        int n;

        scanf("%d", &n);

        int count = 0;
        int val = 0;
        for(int i = 0; i < n; i++) {
            scanf("%d", &val);
            while(val%2 == 0) {
                count++;
                val /= 2;
            }
        }
        
        if(count%2 == 0) {
            printf("Alan\n");
        } else {
            printf("Charlie\n");
        }
    }
    
    return 0;
}
