import heapq

N = int(input())
h = list(map(int, input().split()))
heapq.heapify(h)
for _ in range(N-1):
    for i in list(map(int, input().split())):
        heapq.heappushpop(h, i)
print(h[0])
