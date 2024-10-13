from collections import Counter

A = int(input())
B = int(input())
C = int(input())

result = A * B * C  # 최대 9자리
counter = dict(Counter(str(result)))
numbers ='0123456789'

for number in numbers:
    print(counter[number] if number in counter else 0)