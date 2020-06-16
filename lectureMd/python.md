
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

# DB 연동

- API
    - mysqlclient 설치
        - 가상환경 실행
        - pip install mysqlclient
        - Error 나면, 아래 사이트 참고
            - 해결 설명 : https://lemontia.tistory.com/756
            - mysqlclient 수동 다운페이지 : https://www.lfd.uci.edu/~gohlke/pythonlibs/#mysqlclient.Then

- 연결설정
    - 프로젝트의 settings.py
        - ```
            DATABASES = {
                'default': {
                    'ENGINE': 'django.db.backends.mysql',
                    'NAME': 'user03', # DB명
                    'USER': 'user03', # user id
                    'PASSWORD': 'user03', # user pw
                    'HOST': 'localhost', # DB ip
                    'PORT': '3306' # PORT
                }
            }
          ```

- Model 생성 (VO, Repository 역할), migration
    - migration? 
        - 생성한 모델을 이용하여 DB에 연동하는 작업
        - django에서 기본 제공되는 Model들로 전체 migration 실행
            - 전체 migration : DB에 실제 추가하는것이 아니고 스크립트로 저장
            - cmd
                - python manage.py makemigrations 실행(DB와 연결)
                - No changes detected 뜨면 성공
                - python manage.py migrate 실행(기본 테이블 생성)
                - initial ... ok 뜨면 성공
        - 개별 app들을 mitration 실행
    - JPA와 비슷
    - CRUD Model의 메서드 사용
    - 하나의 모델은 하나의 테이블과 같음
    - 멤버변수(속성)은 테이블의 컬럼과 같음
    - 개발자가 생성하는 모델은 django.db.models.Model 상속받아서 생성
        - config/setting.py
            - ```
                INSTALLED_APPS = [
                    'django.contrib.admin',
                    'django.contrib.auth',
                    'django.contrib.contenttypes',
                    'django.contrib.sessions',
                    'django.contrib.messages',
                    'django.contrib.staticfiles',
                    'notice.apps.NoticeConfig',
                ]
              ```
        - app name/models.py
            - ```
                class Notice(models.Model): 
                    # 클래스 변수
                    num = models.AutoField(primary_key=True)
                    title = models.CharField(max_length=200)
                    writer = models.CharField(max_length=200)
                    contents = models.TextField()
                    createDate = models.DateTimeField(auto_now_add=True)
                    hit = models.IntegerField(default=0)
              ```
        - cmd
            - python manage.py makemigrations notice
            - python manage.py migrate notice
            - CRUD 작업 test
                - python manage.py shell
                    - from notice.models import Notice
                    - n = Notice(title='t1', writer='w1', contents='c1')
                    - n.save()
                    - Notice.objects.all()
                    - n = Notice.objects.get(pk=1)
                    - n.title
                    - n.title='change'
                    - n.save()
                    - n.delete()
                    - n.delete(pk=2)


