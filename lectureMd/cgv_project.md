
# MYSQL 시간대(timezone) setting

- cmd docker 컨테이너 내에서 mysql root 계정 접속, 해당 DB 선택 후, 아래 명령어 실행
    - set global time_zone='Asia/Seoul';

# twillo (sms API)

- ref : https://jybaek.tistory.com/859, https://2bmw3.tistory.com/4
- 설정관련은 후자가, 코드는 전자가 도움이 되었음
- sms를 보내는 부분만 비동기로 진행

# redis (lettuce)

- docker에 redis 설치
    - 이미지 다운로드 : docker pull redis
    - 컨테이너 생성 : 
        - docker run --name myredis -rm -d -p 6379:6379 redis (가능하면 아래 커스텀 버전 쓸 것)
    - 컨테이너 실행 : docker exec -it redis /bin/bash
    - redis 직접 접속 : redis-cli -p 6379
    - custom 설치(비밀번호 지정, 외부접속 허용 등)
        - ref : https://m.blog.naver.com/wideeyed/221896378630
        - docker run --name myredis -p 6379:6379 -v C:\redis\redis.conf:/usr/local/etc/redis/redis.conf redis redis-server /usr/local/etc/redis/redis.conf

- docker 명령어 정리
    - ref : http://redisgate.kr/redis/education/docker_intro.php
    - 옵션
        - --rm : 실행 정지되면 자동으로 컨테이너를 지워 줌
        - -d : 백그라운드에서 데몬으로 실행됨
        - -p [외부포트 : 내부포트] : docker 컨테이너의 외부/내부포트 지정 => ex) -p 8080:6379
        - -v [외부 디렉토리 : 내부 디렉토리] : 실제 OS 폴더와 해당 컨테이너 내부의 폴더를 연결시켜 줌. 보통 컨테이너가 종료되면 해당 컨테이너에 저장되었던 데이터들이 모두 날아가는데, 이를 방지하기 위함

- redis GUI tool
    - download : https://www.electronjs.org/apps/p3x-redis-ui
    - 설치 참고 : https://qjadud22.tistory.com/55

- CRUD 명령어
    - 참고 : https://firstboos.tistory.com/entry/redis-%EA%B0%84%EB%8B%A8-%EB%AA%85%EB%A0%B9%EC%96%B4-%EC%A0%95%EB%A6%AC
    - keys : 저장된 모든 키를 검색할때 key 명령을 사용
        - keys pattern
        - ex) keys * //모든키 검색
        - ex) keys s* //s로 시작하는 모든 키 검색
        - ex) keys *2 //2로 끝나는 모든 키 검색
    - randomkey : 저장된 key 중에 하나의 랜덤한 key를 검색할 때 randomkey 명령을 사용
        - randomKey
    - exists : 검색 하려는 key가 존재하는지 여부를 확인할때 exists 명령어를 사용 (반환되는 값이 1이면 존재하는 키값, 0이면 존재하지 않는 키값)
        - exists key
        - ex) exists 1
    - strlen : 검색하려는 key의 value 길이를 확인할때 strlen 명령을 사용
        - strlen key
        - ex) strlen 1
    - flushall : 현재 저장되어 있는 모든key를 삭제 할 때에는 flushall 명령을 사용
        - flushall
    - del : 데이터 삭제 del명령을 사용
        - del key
        - del 1
    - set : 데이터를 저장할 때에는 set 명령을 사용
        - set key value
        - ex) set 1 “sqlmvp”
    - get : 데이터를 검색할 때에는 get 명령을 사용
        - get key
        - ex) get 1
    - rename : 저장된 key 값을 변경할 때에는 rename 명령을 사용
        - rename key newkey
        - rename 1 2

# date/timepicker

- cdn 및 라이브러리는 프로젝트 내를 참고

- ref : https://tarruda.github.io/bootstrap-datetimepicker/

# image 작업관련 (년/월/일 폴더 생성 및 이미지 썸네일화)

- 년/월/일 폴더 생성
    - FilePathGenerator.addTimePath("") 메소드가 "년\월\일" String 값 생성
    - ```
 		String path = FilePathGenerator.addTimePath("")+"\\";   // String path = "년\월\일\";
 		String extendPath = FilePathGenerator.addTimePath(filePath); // String extendPath = "filePath\년\월\일"
 		File file = filePathGenerator.getUseClassPathResource(extendPath);
      ```
- 이미지 썸네일화
    - FileManager.onResizeFunction(int pixel=100) 메소드를 통해 썸네일 이미지로 저장할 것을 선언
    - ```
        fileManager.onResizeFunction(200);	// 이미지 resize를 하려면 해당 함수를 사용하면 됨 (이미지 파일일때만 실행됨)
		String fileName = fileManager.saveTransfer(multipartFile, file); //이미지 파일 저장
      ```

# builder 패턴

- lombok의 @Builder를 사용하여 builder패턴형 클래스 생성 가능
    - MemberCouponVO에 적용함 

- ref : https://johngrib.github.io/wiki/builder-pattern/

# 대용량 DB에서의 랜덤 필드값 가져오는 것에 대한 SQL

- ref : http://blog.naver.com/PostView.nhn?blogId=sinjoker&logNo=221524576602&parentCategoryNo=&categoryNo=93&viewDate=&isShowPopularPosts=true&from=search

- 자세한 설명은 ref를 통해,
    - ```
        // table에 rand로 값을 가져올때 빠르게 가져올수 있도록 randId 필드 생성
        ALTER TABLE banner ADD randId INT NOT NULL;
        ALTER TABLE banner ADD INDEX BANNER_RANDID_INDEX (randId);

        // 각 randId 필드 업데이트
        UPDATE banner SET randId = FLOOR(RAND(28) * 100000000) WHERE num = 28;

        // 필드값 n개 랜덤으로 가져오기 (Limit n)
        select * from banner where randId >= FLOOR((RAND()*100000000)) and type=1 and `index`=0 order by randId limit 1;
      ```

# MYSQL procedule 사용

- MYSQL 내부에서 procedule 선언 및 실행
    - ```
        delimiter //
        DROP PROCEDURE IF EXISTS sideBannerRandSelect; 
        CREATE PROCEDURE sideBannerRandSelect( 
        -- 매개변수 선언
        IN selectedIndex INT
        )
        BEGIN
        -- 지역변수 선언
            DECLARE count INT;
            
            SET count = (SELECT COUNT(num) FROM banner WHERE type=1 AND `index`=selectedIndex);
            SET count = (SELECT FLOOR(0 + RAND() * count - 0));
            
            SELECT * FROM banner WHERE type=1 and `index`=selectedIndex limit count, 1;
            
        END //

        CALL sideBannerRandSelect(0);
      ```

- mybatis로 불러오기
    - CALL 'mysql에서 선언한 프로시저명'
    - ```
        <select id="~" paramType="~VO" returnType="~VO">
            CALL sideBannerRandSelect(#{index})
        </select>
      ```

# 로컬PC로 배포(jar 버전)

- ref : 
    - 배포를 위한 세팅 1 (pom setting 및 test 환경 조성) : https://www.leafcats.com/178
    - 배포를 위한 세팅 2 (jre -> jdk 변경) : https://mainia.tistory.com/5629
    - 배포를 위한 세팅 3 (mvn build를 위한 plugin 추가, [dump 뭐시기 에러 뜰때 사용하면 됨]) : https://www.it-swarm-ko.tech/ko/java/maven-%eb%b9%8c%eb%93%9c-%eb%b0%8f-mavenfailsafeplugin%ea%b0%88%eb%9e%98-vm-%ec%9e%91%eb%b3%84-%ec%9d%b8%ec%82%ac%ec%97%86%ec%9d%b4-%ec%a2%85%eb%a3%8c-%eb%90%a8/835668378/

# 로컬 PC로 배포 (war 버전)

- ref : 
    - tomcat 서버 8버전 설치 : https://tomcat.apache.org/download-80.cgi

# aws로 배포(심화)

- ref : https://jojoldu.tistory.com/259?category=635883


# 내가 한 작업 정리 (다른 사람 도와준건 뺐음)

- com.tm.cgv.admin
    - AdminController
        - member part
        - movieTime part

- com.tm.cgv.auth
    - AuthRepository
    - AuthVO
    - RoleEnum

- com.tm.cgv.config
    - RedisConfig
    - SecurityConfig

- com.tm.cgv.couponInfo
    - CouponInfoRepository
        - couponInfoSelectRecentBirth
        - couponInfoDeleteExpired

- com.tm.cgv.member
    - MembeController
    - MemberBasicVO
    - MemberRepository
    - MemberService
    - MemberVO

- com.tm.cgv.memberCoupon
    - MemberCouponRepository
    - MemberCouponService
        - memberCouponCount

- com.tm.cgv.movieTime
    - MovieTimeRepository
    - MovieTimeService
    - MovieTimeVO

- com.tm.cgv.rememberMe
    - RememberMeRepository
    - RememberMeTokenRepository
    - RememberMeVO

- com.tm.cgv.schedule
    - Schedule
        - hr part

- com.tm.cgv.security
    - CustomAccessDeniedHandler
    - CustomLoginFailureHandler
    - CustomLoginSuccessHandler
    - CustomLogoutHandler
    - CustomRememberMeLoginSuccessHandler
    - SecurityInitializer

- com.tm.cgv.util
    - bit
    - BitFuction
    - FileManager
        - 이미지 리사이징 기능 및 이미지파일인지 체크
    - FilePathGenerator
        - 년/월/일 폴더 생성 가능하도록 경로 생성하는 부분
    - GenerateRandomNumber
    - MemberInfoMaker
    - SmsSender

