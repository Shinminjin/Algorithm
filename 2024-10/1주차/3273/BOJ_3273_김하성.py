import sys

def solution():
    N = int(sys.stdin.readline())
    arr = list(map(int, sys.stdin.readline().split()))
    X = int(sys.stdin.readline())
    arr.sort()

    left = 0
    right = N-1
    result = 0

    while left < right:
        temp = arr[left] + arr[right]
        if temp == X:
            result += 1

        if temp < X: left += 1
        else: right -= 1

    print(result)

solution()