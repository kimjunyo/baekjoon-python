# 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> 1/3 -> 1/4 -> 2/3 -> 3/2 -> 4/1 -> 5/1 -> 4/2 ->

# 1차 시도 - 시간 초과
# array = []
# first = "1/1"
# array.append(first)
#
# for i in range(2, 4473):
#     first_num = int(first[0])
#     second_num = int(first[2])
#     if i % 2 == 0:
#         for j in range(i):
#             first_num = j + 1
#             second_num = i - j
#             array.append(str(first_num) + '/' + str(second_num))
#     else:
#         for j in range(i):
#             first_num = i - j
#             second_num = j + 1
#             array.append(str(first_num) + '/' + str(second_num))
# a = int(input())
# print(array[a - 1])

# 2차 시도 - 시간 초과
# first = "1/1"
# direction = 1
# a = int(input())
# for i in range(a-1):
#     first_num = int(first.split('/')[0])
#     second_num = int(first.split('/')[1])
#     if direction == 1 and first_num == 1:
#         second_num += 1
#         direction = -1
#     elif direction == 1:
#         first_num -= 1
#         second_num += 1
#     elif direction == -1 and second_num == 1:
#         first_num += 1
#         direction = 1
#     elif direction == -1:
#         first_num += 1
#         second_num -= 1
#     first = str(first_num) + '/' + str(second_num)
# print(first)

# 정답
num = int(input())
line = 1

while num > line:
    num -= line
    line += 1

# 짝수일경우
if line % 2 == 0:
    a = num
    b = line - num + 1
# 홀수일경우
elif line % 2 == 1:
    a = line - num + 1
    b = num

print(f'{a}/{b}')