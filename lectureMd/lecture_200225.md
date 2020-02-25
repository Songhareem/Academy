
# File 입출력

- exist() : 해당 파일이 존재하는가
- getName() : 파일명 가져오기
- getPath() : 상대경로 가져오기
- getAbsolutePath() : 절대경로 가져오기
- isDirectory() : 디렉토리인지
- isFile() : 파일인지
- list() : 파일 이름들 스트값링 값으로 반환
- listFiles() : 파일들을 파일로 반환
- mkdir() : 해당 장소에 디렉토리 생성
- mkdirs() : 두개 이상 만들때
- renameTo() : 이름 바꾸기
- delete() : 파일 및 빈폴더 삭제 (폴더 안이 비어있어야 가능)
- length() : 해당 폴더 및 파일의 크기

# FileReader

- BufferReader와 함께 사용

# FileWriter

# 예외

- java.lang.NumberFormatException : 문자열을 parseInt 시키는 등 맞지 않는 변환에서 생기는 예외

- java.lang.NullPointerException : Null 참조 예외

- java.lang.IndexOutOfBoundsException : 배열이나 리스트 등 크기가 벗어난 인덱스에서 자료를 가져오려고 할때 발생하는 예외

# 배열의 초기값

- 참조타입 변수명 = new 참조타입[n]
    - 참조타입의 디폴트는 null이므로 null!
    - int타입의 디폴트는 1이므로 1