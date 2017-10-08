#include <iostream>

long largestPower(long n) {
    n = n | (n >> 1);
    n = n | (n >> 2);
    n = n | (n >> 4);
    n = n | (n >> 8);

    return (n+1) >> 1;
}

int main() {
    long n = 15000;

    std::cout << largestPower(n);

    return 0;
}