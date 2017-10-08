#!/usr/bin/python3

"""
1
3 3
aba
xyz
bdr
axbaydb
"""

def canGenerateString(matrix, n, m, s):
    count = [[0 for x in range(26)] for y in range(n)]

    for i in range(0, n):
        for j in range(0, m):
            val = ord(matrix[i][j])
            val -= 97
            count[i][val] += 1

    for i in range(0, len(s)):
        v1 = i%n
        v2 = ord(s[i])-97
        if (count[v1][v2] > 0):
            count[v1][v2] -= 1
        else:
            return False

    return True

t = input()
t = int(t)

for z in range(0, t):
    n, m = [int(x) for x in input().split()]

    matrix = []
    for i in range(0, n):
        foo = input()
        matrix.append(foo)

    s = input()

    if (canGenerateString(matrix, n, m, s)):
        print("Yes")
    else:
        print("No")