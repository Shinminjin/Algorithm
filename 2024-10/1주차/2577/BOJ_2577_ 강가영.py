A = int(input())
B = int(input())
C = int(input())

a = list(str(A * B * C))

for i in range(10):
    cnt = a.count(str(i))
    print(cnt)
