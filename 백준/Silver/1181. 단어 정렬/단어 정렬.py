N=int(input())
word=[]

for _ in range(N):
    a=input()
    word.append(a)
word=list(set(word))
word_2=[]
for i in range(len(word)):
    b=len(word[i])
    word_2.append([b,word[i]])

word_2.sort()

for i in range(len(word_2)):

    print(word_2[i][1])