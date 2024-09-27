import sys

N,M = map(int, sys.stdin.readline().split())
dlist = []
blist = []

for i in range(N):
    dlist.append(sys.stdin.readline())

for i in range(M):
    blist.append(sys.stdin.readline())

alllist = sorted(list(set(dlist)&set(blist)))
3 
print(len(alllist))
for i in alllist:
    print(i, end="")