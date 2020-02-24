
# Collection

- boolean add() : 새 요소 추가
- void clear() : 모든 요소 삭제
- boolean remove(Object) : 해당 객체 삭제 후, 자리 당김
- boolean contains(Object) : 해당 객체가 있는지
- boolean isEmpty() : 비어있는지 return
- int size() : 요소의 갯수를 반환
- Object[] toArray() : Object 배열로 반환
- Iterator< E > iterator() : 반복자(Iterator)로 반환  

# Iterator

- 반복자
- List, Set 구현한 모든 클래스에서 사용 가능
- boolean hasNext() : 다음 요소 있는지
- next() : ++iter 후, 다음 요소 반환

# Map

- boolean containsKey(Object key) : 매개변수 key가 해당 맵에 존재 하는지
- boolean containsKey(Object value) : 매개변수 value가 해당 맵에 존재 하는지
- V get(Object key) : 해당 key로 value 반환
- V put(key, value) : entry(key, value) 삽입
- V remove(Object Key) : 해당 key와 value 삭제
- Set< K > keySet()   : 맵의 key를 set객체로 반환 

# Calender

- get(field) : Calendar 변수에 저장된 값을 반환
- getTimeInMillis() : 1월 1일부터 시간 흐름 차 구할때
- set(field, 값) : Calender 변수에 저장된 값 변환
- setTime(Date) : Date 객체 Calendar로 변환
- setTimeMillis(Long) : millsec을 Calendar 로 변환
- after(Object) : 현재 Calendar객체가 매개변수로 온 객체를 나타내는 시간보다 나중인지
- before(Object) : 현재 Calendar 객체가 매개변수로 온 객체를 나타내는 시간보다 이전인지
- roll(field, amount) : field 값을 amount 만큼 증감 시킴, 다른 필드 영향 X
- add(field, amount) : field 값을 amount 만큼 증감 시킴, 다른 필드 영향 O

# 예외처리

- 오류 및 예외는 프로그래밍 종류 유발

- 예외처리는 비 정상적인 종료를 막고 프로그래밍이 계속 실행될 수 있게 처리하는 방식

- 오류(Err)
    - 개발자가 예측 처리 할 수 없는 것이 대부분, 처리 X
- 예외(Exception)
    - 개발자가 예측 가능한 문제, 미리 대비 가능

- try - catch
    - try : 예외발생 가능한 코드
    - catch : 다중 catch 가능, 예외 객체 타입을 매개변수로 받음

- throws 선언
    - 예외처리는 자기자신이 아니라 호출한 쪽에서 처리하도록 유도

- 사용자 정의 예외 클래스

# IO

- 기준 : 프로그램
- 스트림(Stream) : 프로그램과 HDD 사이에 통신 라인(단방향 통신)
    - 입력스트림
    - 출력스트림

- java.io.InputStream
    - int read() : 입력스트림으로부터 다음 바이트를 읽어들임
    - int read(byte[] b) : 입력스트림으로부터 바이트를 읽어서 바이트 배열에 저장, 더이상 읽을 바이트가 없으면 -1 반환
    
- java.io.OutputStream
    - void write(int b) : 출력스트림으로 해당 바이트를 출력
    - void write(byte[] b) : 출력스트림으로 바이트 배열만큼 출력

- 바이트기반 스트림
    - byte 단위 데이터 처리
    - 사진등 파일
    - FileInputStream / FileOutputStream
    - ByteArrayInputStream / ByteArrayOutputStream
    - 보조 스트림 : 다른 스트림의 기능을 향상시켜주는 스트림
        - FilterInputStream / FilterOutputStream
        - BufferdInputStream / BufferdOutputStream

- 문자기반 스트림
    - char 단위(유니코드) 데이터 처리
    - 채팅 문자등 문자열
    - FileReader / FileWriter
    - StringReader / StringWriter
    - InputStringReader / OutputStringReader

    - 보조스트림
        - BufferdReader / BufferdWriter
        - FilterReader / FilterWriter