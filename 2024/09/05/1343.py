board_array = input().split(".")
str_ans = ""

for molinomio in board_array:
    A = len(molinomio) % 4
    if A == 0:
        str_ans += "AAAA" * (len(molinomio) // 4)
    elif A == 2:
        str_ans += "AAAA" * (len(molinomio) // 4) + "BB"
    else:
        str_ans = "-1"
        break
    str_ans += "."
print(str_ans.removesuffix("."))
