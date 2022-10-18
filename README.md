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