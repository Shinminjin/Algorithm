T = int(input())

for i in range(T):
    N = int(input())
    nlist = list(map(int, input().split()))
    
    max = nlist[0]
    min = nlist[0]
    for j in nlist:
        if max < j :
            max = j
        if min > j :
            min = j

    print(min, max)