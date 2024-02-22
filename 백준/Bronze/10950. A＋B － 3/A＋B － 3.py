a=int(input())
d=[]
for i in range(a):
    b,c=map(int, input().split())
    d.append(b+c)
for i in range(a):
    print(d[i])