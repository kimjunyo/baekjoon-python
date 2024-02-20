def reward(x, y, z):
    if(x==y and y==z):
        return 10000+x*1000
    elif(x==y):
        return 1000+x*100
    elif(z==y):
        return 1000+y*100
    elif(x==z):
        return 1000+x*100
    else:
        return max(x,y,z)*100


a, b, c = map(int, input().split())
r = reward(a, b, c)
print(r)
