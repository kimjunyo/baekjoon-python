N = int(input())
groupWordNum = 0
for i in range(N):
    a = input()
    b = list(set(a))
    isGroupWord = True
    for j in range(len(a) - 1):
        if a[j] != a[j + 1] and b.count(a[j]) != 0 and b.count(a[j+1]) != 0:
            b.remove(a[j])
        elif a[j] == a[j + 1] and b.count(a[j]) != 0:
            pass
        else:
            isGroupWord = False
            break
    if isGroupWord:
        groupWordNum += 1
print(groupWordNum)
