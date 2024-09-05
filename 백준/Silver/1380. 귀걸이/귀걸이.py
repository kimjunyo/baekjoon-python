n = -1
ans = []
while n != 0:
    n = int(input())
    student_array = []
    earing_list = []
    for _ in range(n):
        student_array.append(input())
    for _ in range(2 * n - 1):
        earing_list.append(input())
    student_earling_return = [0] * len(student_array)
    for i in earing_list:
        earling = i.split()
        student_index = int(earling[0])
        student_earling_return[student_index - 1] += 1

    if n != 0:
        not_return = student_earling_return.index(1)
        ans.append(student_array[not_return])

for i in ans:
    print(ans.index(i)+1, i)
