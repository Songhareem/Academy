
# VO Class

- 데이터 덩어리, getter setter

# DAO Class

VO를 처리하는 로직을 가진 객체

# Controll Class

DAO의 메소드를 이용한 워크플로우를 가진 클래서

# View Class

데이터를 양식에 맞춰 보여주는 클래스

# 네트워크

- 서버 - 클라이언트
    - 서버
        - 서비스를 제공하는 Software(프로그램, app)
    - 클라이언트
        - 서비스를 이용하는 요청

- IP
    - 하드웨어 주소
    - IPv4 = 000.000.000.000
    - IPv6 = 0000:0000:0000:0000:0000:0000:0000:0000

- Port
    - 소프트웨어 주소
    - well-known-ports는 생략해도 무방 ( ex- http = :80 )
    - TCP / UDP
        - TCP 
            - 신뢰성 있는 연결
            - DDOS 분산 서비스 거부 공격, TCP 취약점(반드시 응답해야한다) 공격
        - UDP
            - 신뢰성 없는 연결
    Protocol
        - 통신규약

# 방화벽 세팅 (window 기준)

- 방화벽 - 고급설정 - 인바운드 규칙 - 새규칙 - 포트 - 