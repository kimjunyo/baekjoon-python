a = list(input())

tmp = []
ans = []

a_length = len(a)
for i in range(1, a_length - 1):
    for j in range(i + 1, a_length):
        first = a[:i]
        second = a[i:j]
        third = a[j:]
        first.reverse()
        second.reverse()
        third.reverse()
        tmp.append(first + second + third)

for b in tmp:
    ans.append(''.join(b))

print(sorted(ans)[0])