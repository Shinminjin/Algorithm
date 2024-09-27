from collections import deque

def bfs(x, y):
    global cnt
    q = deque([(x, y)])
    graph[x][y] = 0

    while q:
        x, y = q.popleft()
        graph[x][y] = 0

        if (x+1) < N:
            if graph[x+1][y] == 1:
                graph[x+1][y] = 0
                q.append(((x+1), y))

        if (y+1) < M:
            if graph[x][y+1] == 1:
                graph[x][y+1] = 0
                q.append((x, (y+1)))

        if (x-1) >= 0:
            if graph[x-1][y] == 1:
                graph[x-1][y] = 0
                q.append(((x-1), y))

        if (y-1) >= 0:
            if graph[x][y-1] == 1:
                graph[x][y-1] = 0
                q.append((x, (y-1)))

T = int(input())

for _ in range(T):
    M, N, K = map(int, input().split())
    graph = [[0]*M for _ in range(N)]
    for _ in range(K):
        x, y = map(int, input().split())
        graph[y][x] = 1

    cnt = 0
    for i in range(M):
        for j in range(N):
            if graph[j][i] == 1:
                bfs(j, i)
                cnt += 1

    print(cnt)