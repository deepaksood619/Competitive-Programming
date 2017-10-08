#include <iostream>

void fastscan(int &number)
{
    //variable to indicate sign of input number
    bool negative = false;
    register int c;
 
    number = 0;
 
    // extract current character from buffer
    c = getchar();
    if (c=='-')
    {
        // number is negative
        negative = true;
 
        // extract the next character from the buffer
        c = getchar();
    }
 
    // Keep on extracting characters if they are integers
    // i.e ASCII Value lies from '0'(48) to '9' (57)
    for (; (c>47 && c<58); c=getchar())
        number = number *10 + c - 48;
 
    // if scanned input has a negative sign, negate the
    // value of the input number
    if (negative)
        number *= -1;
}

int main() {

    int n, q;
    fastscan(n);
    fastscan(q);

    int arr[n];
    int val;
    for(int i = 0; i < n; i++) {
        fastscan(val);
        arr[i] = val;
    }

    int l, r, mean;
    for(int i = 0; i < q; i++) {
        fastscan(l);
        fastscan(r);
        mean = 0;
        for(int j = l-1; j < r; j++) {
            mean += arr[j];
        }
        mean /= r-l+1;
        printf("%d\n", mean);
    }

    return 0;
}