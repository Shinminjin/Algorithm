K = int(input())
a = []
for i in range(K):
    n = int(input())

    if n != 0 : 
        a.append(n)
    else :
        a.pop()
    
print(sum(a))