ans = input().split(" ")
month = ans[0]
day = ans[1].removesuffix(",")
year = ans[2]
hour = ans[3].split(":")[0]
minute = ans[3].split(":")[1]


def is_yoon_year(year_name):
    if year_name % 400 == 0 or year_name % 4 == 0 and year_name % 100 != 0:
        return True
    else:
        return False


month_day_array = [["January", 31], ["February", 28], ["March", 31], ["April", 30], ["May", 31], ["June", 30],
                   ["July", 31], ["August", 31], ["September", 30], ["October", 31], ["November", 30], ["December", 31]]
yoon_month_day_array = [["January", 31], ["February", 29], ["March", 31], ["April", 30], ["May", 31], ["June", 30],
                        ["July", 31], ["August", 31], ["September", 30], ["October", 31], ["November", 30],
                        ["December", 31]]
record = 0
record_day = 0
if is_yoon_year(int(year)):
    total = 366 * 24

    for i in range(12):
        if yoon_month_day_array[i][0] == month:
            for j in range(i):
                record_day += yoon_month_day_array[j][1]
            break
    record += record_day * 24 + (int(day) - 1) * 24 + int(hour) + int(minute) / 60
    print(record / total * 100)
else:
    total = 365 * 24
    for i in range(12):
        if month_day_array[i][0] == month:
            for j in range(i):
                record_day += month_day_array[j][1]
            break
    record += record_day * 24 + (int(day) - 1) * 24 + int(hour) + int(minute) / 60
    print(record / total * 100)
