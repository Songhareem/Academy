
# List
lists = []

lists = ["string", 10, 3.12, True]

# push
lists.append(1)

# update
lists[1] = 200

# delete
del lists[0]
lists.remove(3.12)

for item in lists :
    print(item)

print(lists)

print("======================")

numbers = [3,2,1]

# list 데이터 증식
numbers = numbers * 2

# list 정렬
numbers.sort()

# list 역순
numbers.reverse()

lists = lists + numbers
print(lists)

# list 슬라이싱
li = lists[1:3]

print(li)

# list 관련 함수
# append
# sort
# reverse
# insert(index번호, 값)
# remove(값)
# pop(index번호)
# count(값) : 해당하는 값이 list에 몇개 있는지
# extent(list) : list에 다른 list 더하기
# len(list) : list size
