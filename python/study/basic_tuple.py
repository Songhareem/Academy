# Tuple은 List와 거의 같음
# 단, Tuple은 값을 바꿀 수가 없음.
# 형식은 ()

# 빈 tuple 생성
t1 = ()

# 한개의 요소를 가질 때 , 반드시 붙여야 함
t2 = (1,)

t3 = (1,2,3,"four")
# ()를 생략 해도 무방
t4 = 1,3,4

t3 = t3 + t4

t3=t3*2

for n in t3 :
    print(n)

length = len(t3)
print(length)

# tuple 요소 삭제
del t3[0]

print(t3)
