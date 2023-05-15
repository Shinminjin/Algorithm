import heapq

if __name__=="__main__":

    n = int(input())
    rankSort= []

    # 한줄에 N개의 N번째 값 찾도록 정리
    for _ in range(n):
        numList = list(map(int, input().split()))
        # print(numList)
        # print(rankSort)
        if rankSort:

            for i in numList:
                minVal = rankSort[0]
                if i > minVal:
                    heapq.heappop(rankSort)
                    heapq.heappush(rankSort, i)
        # rankSort 존재하지 않을 때
        else:
            for i in numList:
                heapq.heappush(rankSort, i)


    print(rankSort[0])