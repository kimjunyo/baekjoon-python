# 상수 정의
a = int(input())
result = 0
for a in str(bin(a)):
    if a == '1':
        result += 1
print(result)
