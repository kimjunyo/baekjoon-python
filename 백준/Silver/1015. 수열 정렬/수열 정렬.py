n = int(input())
array = list(map(int, input().split()))

array_sort = sorted(array)
ans = []

for i in range(n):
    idx = array_sort.index(array[i])
    ans.append(idx)
    array_sort.insert(idx, -1)
    array_sort.remove(array[i])
print(*ans)
