a=int(input())
repeat=int(input())
f=0
for i in range(repeat):
    b,c=map(int, input().split())
    f+=b*c
if(f==a):
    print("Yes")
else:
    print("No")