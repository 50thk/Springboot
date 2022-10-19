# Springboot
1. 기본 개발 환경:
    Spring Web, Spring Boot Devtools(변경사항 발생시 자동으로 서버 재가동 / Only gradle(not maven) / Crome에서 Live reload 확장 설치하면 브라우저 새로고침 없이 확인가능), lombok(getter, setter, RequiredArgsConstructor(final로 변수 설정 시 생성자에 설정))

2. 프로젝트 내 파일 설명
    - <프로젝트명> + Application.java / 웹 구동
    - templates 디렉터리 / HTML
    - static 디렉터리 / css, js, img
    - application.properties 파일 / 프로젝트 환경, 데이터베이스 설정
    - src/test/java 디렉터리 / JUnit과 스프링부트의 테스팅 도구를 사용하여 서버를 실행하지 않은 상태에서 src/main/java 디렉터리에 작성한 코드를 테스트
    - build.gradle 파일 / gradle의 환경 파일, 프로젝트의 플러그인, 라이브러리 등 기술

3. Spring 기능

    - @Controller / org.springframework.stereotype.Controller, 클래스를 컨트롤러로 지정
    - @RequestMapping("/app") / org.springframework.web.bind.annotation.RequestMapping, 요청된 URL과의 매핑을 담당(요청 발생 시 컨트롤러를 대상으로 찾음)
    - @ResponseBody / org.springframework.web.bind.annotation.ResponseBody, URL 요청에 대한 응답(return)
    - ORM(object relational mapping) / java의 문법으로 데이터베이스 데이터 처리, 내부에서 자동으로 SQL쿼리로 변환되어 처리됨 / 'ORM을 이용하면 데이터베이스 종류에 상관 없이 일관된 코드를 유지할 수 있어서 프로그램을 유지·보수하기가 편리하다. 개발자가 달라도 통일된 쿼리를 작성할 수 있고 오류 발생률도 줄일 수 있다.'
    - JPA(Java Persistence API) / JPA를 사용하여 데이터베이스를 처리(저장, 조회), JPA는 자바 진영에서 ORM(Object-Relational Mapping)의 기술 표준으로 사용하는 인터페이스의 모음, 인터페이스이므로 구현 클래스 필요, JPA를 구현한 대표적인 실제 클래스에는 하이버네이트(Hibernate)가 있다.
    - H2 database / 주로 개발용이나 소규모 프로젝트에서 사용되는 파일 기반의 경량 데이터베이스이다. 개발시에는 H2를 사용하여 빠르게 개발하고 실제 운영시스템은 좀 더 규모있는 DB를 사용하는 것이 일반적인 개발 패턴.
    - application.properties 설정
        * spring.h2.console.enabled - H2 콘솔의 접속을 허용할지의 여부
        * spring.h2.console.path - 콘솔 접속을 위한 URL 경로
        * spring.datasource.url - 데이터베이스 접속을 위한 경로
        * spring.datasource.driverClassName - 데이터베이스 접속시 사용하는 드라이버
        * spring.datasource.username - 데이터베이스의 사용자명, 기본값 = sa
        * spring.datasource.password - 데이터베이스의 패스워드
        * spring.jpa.properties.hibernate.dialect - 데이터베이스 엔진 종류를 설정
        * spring.jpa.hibernate.ddl-auto - 엔티티를 기준으로 테이블을 생성하는 규칙을 정의, 개발 환경에서는 보통 update 모드를 사용하고 운영환경에서는 none 또는 validate 모드를 사용 / none - 엔티티가 변경되더라도 데이터베이스를 변경하지 않는다., update - 엔티티의 변경된 부분만 적용한다., validate - 변경사항이 있는지 검사만 한다., create - 스프링부트 서버가 시작될때 모두 drop하고 다시 생성한다., create-drop - create와 동일하다. 하지만 종료시에도 모두 drop 한다.
