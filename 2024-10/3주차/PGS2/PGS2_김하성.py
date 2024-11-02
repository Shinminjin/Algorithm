def solution(string):
    stack = []
    for s in string:
        if s == '(':
            stack.append(s)
        elif s == ')' and stack.length == 0:
            return False
        else:
            stack.pop()

    return stack.length == 0
