
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
    - .\Scripts\activate.bat 실행

- 가상환경 종료
    - deactivate

- Django framework 설치
    - 가상환경 내에서 실행
    - pip install django

- Django Web Project 생성
    - 가상환경 내에서 실행
    - python manage.py startapp config
    - 바깥의 config를 프로젝트명으로 변경
    - django-admin startproject 프로젝트명

- Django Web Project 실행
    - python manage.py runserver

- 부록 : pip 명령어 목록
    - pip -V : pip 버전보기
    - pip list : 현재 설치된 패키지 목록 출력
    - pip install 패키지명 : 패키지 설치
    - pip freeze > requirements.txt : 패키지 목록 정보를 requirements.txt파일에 저장
    - pip install -r requirement.txt : 패키지 목록 정보가 담긴 파일을 불러와서 해당 패키지 목록 설치

# Django의 디자인 패턴 (MTV)

- Model : DAO / VO 역할
    - 프로젝트명/models.py 소스코드 내에 코드 작성

- Template : View 역할
    - HTML
    - config/setting.py 설정
        - templates
            - 'DIRS' : 
            - 'APP_DIRS' : True(project폴더의 templates 경로 찾기)
    - 각 App별 templates 파일의 위치
        - AppName밑에 templates 폴더 생성
        - setting.py 에 App의 templates 폴더의 위치를 등록
        - templates 밑에 AppName 폴더 생성


- View : Controller 역할
    - 응답할 HTML 결과 페이지 매핑 : 프로젝트명/views.py 소스코드 내에 코드 작성
    - 요청 url 매핑 : 프로젝트명/urls.py (config/urls.py 복붙)

# Django 설명
    - static (css, js, image 등 정적 파일 처리, 개발시 필요한 정적 파일)
        - settings.py 설정
            - STATICFILES_DIR = {os.path.join(BASE_DIR, 'static')} 추가
    - media ()
