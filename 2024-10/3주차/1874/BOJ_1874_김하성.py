def solution():
    N = int(input())
    data = []
    Stack = []
    ret = []

    for _ in range(N):
        data.append(int(input()))

    idx = 0

    for i in range(1, (N + 1)):
        Stack.append(i)
        ret.append('+')

        while Stack and Stack[len(Stack) - 1] == data[idx]:
            Stack.pop()
            idx += 1
            ret.append('-')

    if Stack:
        print('NO')
    else:
        for i in ret:
            print(i)


solution()