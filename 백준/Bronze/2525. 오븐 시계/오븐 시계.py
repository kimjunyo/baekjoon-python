def electronic(x, y, z):
    if(y+z>=60):
        hour=(y+z)//60
        y=(y+z)%60
        if(x+hour>=24):
            x=(x+hour)%24
        else:
            x=x+hour
    else:
        y=y+z
    return x, y

a, b = map(int, input().split())
c = int(input())
a, b= electronic(a, b, c)
print(a, b)
