K = int(input())

numbers = []
for _ in range(K):
    number = int(input())
    numbers.append(number) if number else numbers.pop()
print(sum(numbers))