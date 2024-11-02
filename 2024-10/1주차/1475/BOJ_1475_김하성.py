import math

room_num = list(map(int, str(input())))

k = range(9)
v = [0] * len(k)
num_set = dict(zip(k, v))

for n in room_num:
    if (n == 6) | (n == 9):
        num_set[6] += 0.5

    else:
        num_set[n] += 1

answer = math.ceil(max(num_set.values()))
print(answer)
