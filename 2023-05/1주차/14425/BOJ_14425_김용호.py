import sys

if __name__=="__main__":

    n, m = map(int, input().split())

    data = []

    for i in range(n+m):
        data.append((input()))

    s = data[0:n]  #집합S
    checkData = data[n:] #확인값

    result = 0

    # 존재 여부 확인
    for check in checkData:
        if check in s:
            result += 1

    print(result)
