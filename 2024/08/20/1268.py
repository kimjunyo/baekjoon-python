a = int(input())
student = []
student_same = []
for i in range(a):
    b, c, d, e, f = map(int, input().split())
    var = [b, c, d, e, f]
    student.append(var)
    student_same.append(1)

student_sum = []
copy = student_same.copy()

student_num = len(student)
for i in range(student_num):
    same = 0
    copy = student_same.copy()
    for j in range(student_num):
        for k in range(5):
            if student[i][k] == student[j][k] and copy[j] == 1:
                same += 1
                copy[j] = 0
    student_sum.append(same)

print(student_sum.index(max(student_sum)) + 1)
