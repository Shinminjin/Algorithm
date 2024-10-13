from collections import Counter

N = int(input())

counter = dict(Counter(str(N)))
counter['6'] = 0 if '6' not in counter else counter['6']
counter['9'] = 0 if '9' not in counter else counter['9']
six_nine_count = counter['6'] + counter['9']

if six_nine_count and six_nine_count % 2 != 0:
    counter['6'] = int(six_nine_count/2) + 1
    counter['9'] = int(six_nine_count/2) + 1
else:
    counter['6'] = int(six_nine_count/2)
    counter['9'] = int(six_nine_count/2)

max_key = max(counter, key=counter.get)
print(counter[max_key])