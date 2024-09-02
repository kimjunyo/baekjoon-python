a, b, n = map(int, input().split())

# 나머지 정리
# 이렇게 했을 때 문제가 몇 자리가 안나오는 경우가 있음, 그렇기 때문에 반복문을 써야 함

# 일단 나눠질 때까지 나눠야 함
decimal = -1
c = a % b
for i in range(n):
    c *= 10
    if c == c % b:
        decimal = 0
    else:
        decimal = c // b
        c = c % b

print(decimal)