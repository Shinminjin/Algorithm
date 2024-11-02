def solution(prices):
    answer = []
    length = len(prices)

    for i in range(0, length):
        count = 0
        for j in range(i, length - 1):
            if prices[i] > prices[j]:
                break
            else:
                count += 1

        answer.append(count)
    return answer