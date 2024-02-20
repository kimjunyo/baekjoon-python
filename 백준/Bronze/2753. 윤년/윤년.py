def print1():
    print(1)

def print0():
    print(0)

a=int(input())
if(a%400==0):
    print1()
elif(a%4==0 and a%100!=0):
    print1()
else:
    print0()
