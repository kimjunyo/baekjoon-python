def permutation(a, b):
    if b == 0:
        return 1
    return a * permutation(a - 1, b - 1)


def factorial(a):
    if a == 1:
        return 1
    return a * factorial(a - 1)


a = int(input())
result = []
for i in range(a):
    b, c = map(int, input().split())
    result.append(permutation(c, b)/factorial(b))

result_num = len(result)
for i in range(result_num):
    print(int(result[i]))
