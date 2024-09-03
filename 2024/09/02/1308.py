t_y, t_m, t_d = map(int, input().split())
f_y, f_m, f_d = map(int, input().split())
# 1월 31 / 2월 28 29(윤년) / 3월 31일 / 4월 30일 / 5월 31일 / 6월 30일 / 7월 31일 / 8월 31일 / 9월 30일 / 10월 31일 / 11월 30일 / 12월 31일
# 시작일은 2월 29일 X
dday = 0


def is_yoon_year(y):
    if y % 400 == 0:
        return True
    elif y % 100 != 0 and y % 4 == 0:
        return True
    else:
        return False


if is_yoon_year(t_y) and is_yoon_year(f_y):
    diff_y = f_y - t_y - 1
    diff_y %
elif is_yoon_year(t_y):

elif is_yoon_year(f_y):

else:


print("D-:"+str(dday))
# TODO