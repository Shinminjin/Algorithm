N = int(input())
q = []
for i in range (N):
    a = input()
    m = a.split()
    if m[0] == "push" :
        q.append(m[1])
    elif m[0] == "pop" :
        print(q.pop() if len(q) > 0 else -1)
    elif m[0] == "size" :
        print(len(q))
    elif m[0] == "empty" :
        print(1 if len(q) == 0 else 0)
    elif m[0] == "front" :
        print(q[0] if len(q) > 0 else -1)
    elif m[0] == "back" :
        print(q[-1] if len(q) > 0 else -1)