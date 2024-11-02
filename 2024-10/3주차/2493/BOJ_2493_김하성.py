def solution():
    T = int(input())
    arr = list(map(int, input().split(' ')))
    Stack = []

    string = ''
    for i in range(T):
        while Stack:
            if Stack[-1][1] > arr[i]:
                string += str(Stack[-1][0] + 1) + ' '
                break
            Stack.pop()

        if not Stack:
            string += '0 '

        Stack.append([i, arr[i]])

    print(string)


solution()