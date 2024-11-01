def stack_sequence(n, sequence):
    stack = []
    result = []
    current_number = 1  # 1부터 시작해 n까지의 숫자를 push할 예정
    
    for num in sequence:
        # 주어진 수열의 숫자 num에 도달할 때까지 push
        while current_number <= num:
            stack.append(current_number)
            result.append('+')  # push 연산
            current_number += 1
        
        # 스택의 가장 위에 있는 숫자가 현재 수열의 숫자와 같다면 pop
        if stack[-1] == num:
            stack.pop()
            result.append('-')  # pop 연산
        else:
            # 수열을 만족할 수 없는 경우
            return ["NO"]
    
    return result

# 입력 처리 예제
n = int(input())  # 수열의 길이
sequence = [int(input()) for _ in range(n)]  # 수열 입력
output = stack_sequence(n, sequence)

# 출력
for line in output:
    print(line)