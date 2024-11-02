import sys

def _11365():

    NUM = []
    T = int(input())

    for _ in range(T):
        N = int(input())

        if N == 0:
            NUM.pop()
        else:
            NUM.append(N)

    print(sum(NUM))

_11365()