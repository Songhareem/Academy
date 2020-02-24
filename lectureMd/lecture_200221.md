
# StringTokenizer 

- 문자열파싱
- Token: 파싱결과물
- hasMoreToken()
- nextToken()

# Collection

- 여러개의 데이터를 하나의 변수로 다루는것

- 배열
    - 같은 데이터타입만 모아서 사용
    - 배열 생성시, 크기 지정
    - 한번 생성한 배열은 크기 수정 불가능

- Collection 주요 인터페이스 3
    - List
        - 순서유지
        - 데이터 중복 허용
        - 종류
            - ArrayList
            - LinkedList
            - Stack
            - Queue
    - Set
        - 순서유지 X
        - 데이터 중복 비허용
        - 종류
            - HashSet
            - TreeSet(이진트리)
    - Map
        - entry(key, val) 구조
        - 순서유지 X
        - 키 중복 허용 X, 값 중복 허용
        - 이미 있는 키면 값을 수정
        - HashMap, TreeMap, HashTable

# 제네릭

- 타입을 제한

# ArrayList

- add() : 새 요소 추가
- add(index, data) : 해당 자리에 삽입, 나머지는 뒤로 밀림
- set(index, data) : 해당 자리에 데이터 수정
- get() : 해당 인덱스 번호의 요소를 리턴
- size() : 요소의 갯수를 반환
- clear() : 모든 요소 삭제
- remove(index) : 해당 자리 삭제 후, 자리 당김
- isEmpty() : 비어있는지 return
