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

    - annotation
        * @Controller / org.springframework.stereotype.Controller, 클래스를 컨트롤러로 지정
        * @RequestMapping("/app") / org.springframework.web.bind.annotation.RequestMapping, 요청된 URL과의 매핑을 담당(요청 발생 시 컨트롤러를 대상으로 찾음)
        * @ResponseBody / org.springframework.web.bind.annotation.ResponseBody, URL 요청에 대한 응답(return)
        * @Entity / javax.persistence.Entity, 클래스를 엔티티로 지정 / 일반적으로 엔티티에는 Setter 대신 lombok의 @Builder annotation을 통한 빌드패턴을 사용
        * @GeneratedValue / javax.persistence.GeneratedValue, 데이터를 저장할 때 해당 속성에 값을 따로 세팅하지 않아도 1씩 자동으로 증가하여 저장된다. strategy는 고유번호를 생성하는 옵션으로 GenerationType.IDENTITY는 해당 컬럼만의 독립적인 시퀀스를 생성하여 번호를 증가시킬 때 사용한다. strategy 옵션을 생략할 경우에 @GeneratedValue 애너테이션이 지정된 컬럼들이 모두 동일한 시퀀스로 번호를 생성하기 때문에 일정한 순서의 고유번호를 가질수 없게 된다. 이러한 이유로 보통 GenerationType.IDENTITY를 많이 사용한다.
        * @Column / javax.persistence.Column,   엔티티의 속성은 테이블의 컬럼명과 일치하는데 컬럼의 세부 설정을 위해 사용한다. length는 컬럼의 길이를 설정할때 사용하고 columnDefinition은 컬럼의 속성을 정의할 때 사용한다. columnDefinition = "TEXT"은 "내용"처럼 글자 수를 제한할 수 없는 경우에 사용한다. 엔티티의 속성은 @Column 애너테이션을 사용하지 않더라도 테이블 컬럼으로 인식한다. 테이블 컬럼으로 인식하고 싶지 않은 경우에만 @Transient 애너테이션을 사용한다.
        * @Id / javax.persistence.Id, primary key로 지정
        * @ManyToOne / javax.persistence.ManyToOne, N:1 관계 설정, 부모 자식 관계
        * @OneToMany / javax.persistence.OneToMany, 1:N 관계 설정, mappedBy - 참조 엔티티의 속성명, cascade - CascadeType - 질문이 삭제될 때 답변들의 거취 유형(REMOVE 전체 삭제)
        * 테이블의 컬럼명 / createDate 속성의 실제 테이블의 컬럼명은 create_date가 됨. createDate처럼 대소문자 형태의 카멜케이스(Camel Case) 이름은 모두 소문자로 변경되고 언더바(_)로 단어가 구분되어 실제 테이블 컬럼명이 된다.
        * @SpringBootTest / org.springframework.boot.test.context.SpringBootTest, 해당 클래스가 스프링부트 테스트 클래스임을 의미.
        * @Autowired / org.springframework.beans.factory.annotation.Autowired, 스프링의 DI기능으로 해당 객체를 스프링이 자동으로 생성해줌. 객체를 주입하기 위해 사용하는 스프링의 애너테이션이다. 객체를 주입하는 방식에는 @Autowired 외에 Setter 또는 생성자를 사용하는 방식이 있다. 순환참조 문제와 같은 이유로 @Autowired 보다는 생성자를 통한 객체 주입방식이 권장된다. 하지만 테스트 코드의 경우에는 생성자를 통한 객체의 주입이 불가능하므로 테스트 코드 작성시에만 @Autowired를 사용
        * @Test / 해당 메서드가 테스트 메서드임을 의미. 클래스를 JUnit으로 실행 시 @Test 애너테이션이 붙은 메서드가 실행;JUnit은 작성한 테스트코드를 실행하기 위해 사용하는 자바의 테스트 프레임워크
        * @Transactional / org.springframework.transaction.annotation.Transactional, 메서드가 종료될 때까지 DB 세션이 유지된다.
        * @RequiredArgsConstructor / @RequiredArgsConstructor는 롬복이 제공하는 애너테이션으로 final이 붙은 속성을 포함하는 생성자를 자동으로 생성하는 역할을 한다. 롬복의 @Getter, @Setter가 자동으로 Getter, Setter 메서드를 생성하는 것과 마찬가지로 @RequiredArgsConstructor는 자동으로 생성자를 생성한다. 따라서 스프링 의존성 주입 규칙에 의해 객체가 자동으로 주입된다.
        * @Service / 해당 클래스를 서비스로 지정
        * @PathVariable / 가변하는 요청 URL의 주소의 변수 값을 얻을 때 @RequestMapping과 매개변수의 이름이 동일해야함.
        * @PostMapping / @RequestMapping과 동일하게 매핑을 담당하는 역할을 하지만 POST요청만 받아들일 경우에 사용
        * @RequestParam / 템플릿에서 입력한 내용을 얻음, 템플릿에서 얻고자하는 name 속성명과 변수명을 일치시켜야함.
        
    

    - assertEquals(기대값, 실제값) / 테스트에서 기대값과 실제값을 비교하고 같으면 테스트 통과, 다르면 테스트 실패로 처리.
    - findAll, findById, findBySubject,
    - Optional / null값을 유연하게 처리하기 위해 사용하는 클래스, isPresent로 null이 아닌지 맞는지 true, false를 리턴받아 확인
    - ORM(object relational mapping) / java의 문법으로 데이터베이스 데이터 처리, 내부에서 자동으로 SQL쿼리로 변환되어 처리됨 / 'ORM을 이용하면 데이터베이스 종류에 상관 없이 일관된 코드를 유지할 수 있어서 프로그램을 유지·보수하기가 편리하다. 개발자가 달라도 통일된 쿼리를 작성할 수 있고 오류 발생률도 줄일 수 있다.'
    - JPA(Java Persistence API) / JPA를 사용하여 데이터베이스를 처리(저장, 조회), JPA는 자바 진영에서 ORM(Object-Relational Mapping)의 기술 표준으로 사용하는 인터페이스의 모음, 인터페이스이므로 구현 클래스 필요, JPA를 구현한 대표적인 실제 클래스에는 하이버네이트(Hibernate)가 있다.
    - H2 database / 주로 개발용이나 소규모 프로젝트에서 사용되는 파일 기반의 경량 데이터베이스이다. 개발시에는 H2를 사용하여 빠르게 개발하고 실제 운영시스템은 좀 더 규모있는 DB를 사용하는 것이 일반적인 개발 패턴.
    - Entity / 데이터베이스 테이블과 매핑되는 자바 클래스, 모델, 도메인 모델이라고 부르기도 함.
    - Repository / 엔티티에 의해 생성된 데이터베이스 테이블에 접근하는 메서드들(예: findAll, save 등)을 사용하기 위한 인터페이스이다. 데이터 처리를 위해서는 테이블에 어떤 값을 넣거나 값을 조회하는 등의 CRUD(Create, Read, Update, Delete)가 필요하다. 이 때 이러한 CRUD를 어떻게 처리할지 정의하는 계층
    - 스프링의 의존성 주입(Dependency Injection) 방식 3가지
        * @Autowired 속성 - 속성에 @Autowired 애너테이션을 적용하여 객체를 주입하는 방식
        * 생성자 - 생성자를 작성하여 객체를 주입하는 방식 (권장하는 방식)
        * Setter - Setter 메서드를 작성하여 객체를 주입하는 방식 (메서드에 @Autowired 애너테이션 적용이 필요하다.)
    - application.properties 설정
        * spring.h2.console.enabled - H2 콘솔의 접속을 허용할지의 여부
        * spring.h2.console.path - 콘솔 접속을 위한 URL 경로
        * spring.datasource.url - 데이터베이스 접속을 위한 경로
        * spring.datasource.driverClassName - 데이터베이스 접속시 사용하는 드라이버
        * spring.datasource.username - 데이터베이스의 사용자명, 기본값 = sa
        * spring.datasource.password - 데이터베이스의 패스워드
        * spring.jpa.properties.hibernate.dialect - 데이터베이스 엔진 종류를 설정
        * spring.jpa.hibernate.ddl-auto - 엔티티를 기준으로 테이블을 생성하는 규칙을 정의, 개발 환경에서는 보통 update 모드를 사용하고 운영환경에서는 none 또는 validate 모드를 사용 / none - 엔티티가 변경되더라도 데이터베이스를 변경하지 않는다., update - 엔티티의 변경된 부분만 적용한다., validate - 변경사항이 있는지 검사만 한다., create - 스프링부트 서버가 시작될때 모두 drop하고 다시 생성한다., create-drop - create와 동일하다. 하지만 종료시에도 모두 drop 한다.
    - 스프링부트에서 template을 사용하기 위해서는 템플릿 엔진을 사용해야함 (Thymeleaf, Mustache, Groovy, Freemarker, Velocity 등)