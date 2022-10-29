package com.mysite.sbb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// interface에 JpaRepository를 상속, Generics type으로 repository의 대상이 되는 entity의 type과 해당 entity의 pk의 속성 타입을 지정해줌
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // JpaRepository를 상속한 QuestionRepository 객체가 생성될때 벌어진다. 
    // (DI에 의해 스프링이 자동으로 QuestionRepository 객체를 생성한다. 이 때 프록시 패턴이 사용된다고 한다.) 
    // 리포지터리 객체의 메서드가 실행될때 JPA가 해당 메서드명을 분석하여 쿼리를 만들고 실행
    // findBy + 엔티티의 속성명(예:findBySubject)과 같은 리포지터리 메서드를 작성하면 해당 속성의 값으로 데이터를 조회할수 있다.
    // And, Or, Between, LessThan, GreaterThanEqual, Like, In, OrderBy 등 조합 가능
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
}
