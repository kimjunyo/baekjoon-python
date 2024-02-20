def alarmEarly(x, y):
    if (y - 45 < 0):
        if (x - 1 < 0):
            x = 23
        else:
            x = x - 1
        y = y + 15
    else:
        y = y - 45
    return x, y

a, b = map(int, input().split())
a, b = alarmEarly(a, b)
print(a, b)
