
# Django 프로젝트

- python 설치
    - python 홈페이지 통해서 설치 or
    - Anaconda : python + 데이터사이언스 필요한 라이브러리 포함 or
    - Miniconda : python + conda 관리 명령어 포함

- 가상환경
    - 프로젝트 별로 다른 버전으로 설치하려할 때, 도움 
    - system에 영향 없어서 관리 용이

- 가상환경 생성
    - cmd에서 가상환경 setup할 경로로 이동
    - python -m venv 가상환경명(폴더명)

- 가상환경 실행
    - 가상환경 폴더 내로 이동
    - .\Script\activate.bat 실행

- 가상환경 종료
    - deactivate

- Django framework 설치
    - 가상환경 내에서 실행
    - pip install django

- Django Web Project 생성
    - 가상환경 내에서 실행
    - django-admin startproject 프로젝트명

- Django Web Project 실행
    - python manage.py runserver

- 부록 : pip 명령어 목록
    - pip -V : pip 버전보기
    - pip list : 현재 설치된 패키지 목록 출력
    - pip install 패키지명 : 패키지 설치
    - pip freeze > requirements.txt : 패키지 목록 정보를 requirements.txt파일에 저장
    - pip install -r requirement.txt : 패키지 목록 정보가 담긴 파일을 불러와서 해당 패키지 목록 설치