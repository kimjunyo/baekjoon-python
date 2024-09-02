# Python codingtest 코드 모음집
### 입력
- 나눠서 입력받기 
```python
a, b = map(int, input().split())
```
## 2024.08.08
- 함수 정의 시 맨 위에 선언
- 재귀함수 사용 시 빠져나오는 구멍 항상 존재해야 함
- double -> int: int() 메서드 사용!!
```python
def permutation(a, b):
    if b == 0:
        return 1
    return a * permutation(a - 1, b - 1)


def factorial(a):
    if a == 1:
        return 1
    return a * factorial(a - 1)


a = int(input())
result = []
for i in range(a):
    b, c = map(int, input().split())
    result.append(permutation(c, b) / factorial(b))

result_num = len(result)
for i in range(result_num):
  #int method 사용하여 정의
    print(int(result[i]))
```
- 상수 정의
  - 이거는 따로 만드는 방법이 C언어나 자바와 달리 정의할 필요가 없다.
  - 보통 대문자나 따로 module을 만들어 import해서 만든다.
- 문자열 순서 비교
  - 문자 하나는 아스키코드라고 생각했는데 유니코드랑 동일하다.
  - "it", "im" 이런 거는 어떻게 비교를 하냐. 다음 코드를 보자.
```python
a = "it"
b = "im"
if a<b:
    print(b)
else:
    print(a)
```
- python에서는 첫 문자의 유니코드를 비교하고 아니면 다음 문자의 유니코드를 비교하여 순서를 따진다.

```python
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
```
- ['im', 'but', 'no', 'cannot', 'it', 'more', 'yours', 'wait', 'wont', 'i', 'hesitate']
  - word는 이렇게 결과값이 출력되는데 같은 것은 없애는 역할을 함. set한 다음에 다시 배열로 바꾸는 과정은..
- [[1, 'i'], [2, 'im'], [2, 'it'], [2, 'no'], [3, 'but'], [4, 'more'], [4, 'wait'], [4, 'wont'], [5, 'yours'], [6, 'cannot'], [8, 'hesitate']]
  - 우선 배열의 첫번째 index의 애를 다루고 만약 같으면 다음 문자열의 순서를 다룸.
## 2024.08.09
### 1193 (오답)
- 원인 : 시간 초과가 계속 발생 
  - 반복문 하나 하면 시간 초과 발생
  - 메모리 제한이 적음. 이런 경우 경우를 나누는 것을 생각해 봐야 겠다..
### 1251
```python
a = list(input())
b = a
a.sort()
print(b)
```
- b와 a가 똑같이 나오는 이유는 똑같은 곳을 가르키기 때문 (방어적 복사가 안됨)
  - 이럴 때는 copy()를 넣어줘야 함.
```python
a = list(input())
b = a.copy()
a.sort()
line1 = b.index(a[0])
line2 = b.index(a[1])
if b.index(a[0]) == len(b) - 1:
    if b.index(a[1]) == len(b) - 2:
        line1 = b.index(a[2])
        line2 = b.index(a[3])
    else:
        line1 = b.index(a[1])
        line2 = b.index(a[2])
else:
    if b.index(a[1]) == len(b) - 1:
        line2 = b.index(a[2])
c = b[0:line1 + 1]
d = b[line1 + 1:line2 + 1]
e = b[line2 + 1:]
c.reverse()
d.reverse()
e.reverse()
for i in c:
    print(i, end="")
for i in d:
    print(i, end="")
for i in e:
    print(i, end="")
```
- 오답
  - 일단 딱 봐도 안됨.
  - 인덱스로 하는 것은 아닌 듯
  - 해답 : 그리디 알고리즘 이용
    - 그리디 알고리즘이란?
      - 최선의 선택을 하는 알고리즘

```python
a = list(input())

tmp = []
ans = []

a_length = len(a)
for i in range(1, a_length - 1):
    for j in range(i + 1, a_length):
        first = a[:i]
        second = a[i:j]
        third = a[j:]
        first.reverse()
        second.reverse()
        third.reverse()
        tmp.append(first + second + third)

for b in tmp:
    ans.append(''.join(b))

print(sorted(ans)[0])
```
- input()을 list로 받으면 문자 하나하나가 리스트로
- reverse함수는 index를 거꾸로 해준다.
  - first+second+third = ['m','b','o','l','e','t','i']
  - 이런 식으로 문자열 하나씩으로 배열이 만들어짐.
- append는 배열에다가 넣는 거
- join은 배열 안의 것을 다 이어 붙이는 것.
- sorted(배열)은 배열 정리하는 것
  - 배열 자체는 정렬 안됨.

## 2024.08.20
```python
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

```
- 많은 사람들과 하는 것은 중복이 되지 않으므로 student_same 배열 생성
- copy를 한 다음 한 번 반복문 돌면 다시 리셋