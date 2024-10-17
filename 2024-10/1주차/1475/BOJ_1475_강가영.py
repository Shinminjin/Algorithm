N = input()

a = []
for i in range(10):
    a.append(list(N).count(str(i)))

if (a[6] + a[9]) % 2:
    a[6] = a[9] = int((a[6] + a[9]) / 2) + 1
else:
    a[6] = a[9] = int((a[6] + a[9]) / 2)

print(max(a))