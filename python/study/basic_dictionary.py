# Dictionary
# Key와 Value로 이루어짐
# {key:value, key2:value2,...}

d = {"d1":"name", "d2":"email", "d3":"phone"}

# 수정
d['d3']="01055555555"

# 삭제
del d['d2']

# 추가
d['d4']="test"

print(d['d3'])
print(d)

### Dictionary 함수들
# Key를 가지고 dict_keys로 생성
# 참조변수명.keys()

k = d.keys()

for k2 in k :
    print(k2)

# 만약에 List가 필요 하다면
l = list(k)
print(l)