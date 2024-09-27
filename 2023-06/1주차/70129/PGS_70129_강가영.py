def solution(s):
    num = 0
    count = 0
    while s != '1':
        sLen = len(s)
        s = s.replace('0','')

        num += sLen - len(s)
        count += 1

        s = bin(len(s)).replace('0b','')
        
    answer = [count,num]
    return answer