from collections import deque

def solution():
    N, K = map(int, input().split(' '))

    dq = deque()

    for i in range(N):
        dq.append(i+1)

    ret = '<'

    while dq:
        if len(dq) <= 1:
            ret += str(dq.pop())
            ret += '>'
            break

        for i in range(K - 1):
            dq.append(dq.popleft())

        ret += str(dq.popleft())
        ret += ', '
    print(ret)
solution()
