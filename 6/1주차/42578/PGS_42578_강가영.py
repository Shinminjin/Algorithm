def solution(clothes):
    count = 0
    for i in range(len(clothes)):
        for j in range(i,len(clothes)):
            if clothes[i][1] != clothes[j][1]:
                count += 1
    return count + len(clothes)