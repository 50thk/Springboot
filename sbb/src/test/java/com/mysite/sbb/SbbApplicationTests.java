package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Transactional
	@Test
	void testJpa() {
		// 1.
		// Question q1 = new Question();
		// q1.setSubject("sbb가 무엇인가요?");
		// q1.setContent("sbb가 무엇인지에 대해서 알고 싶습니다.");
		// q1.setCreateDate(LocalDateTime.now());
		// this.questionRepository.save(q1);

		// Question q2 = new Question();
		// q2.setSubject("스프링부트 모델 질문입니다.");
		// q2.setContent("스프링이 좋나요 Node.js가 좋나요");
		// q2.setCreateDate(LocalDateTime.now());
		// this.questionRepository.save(q2);

		// 2.
		// List<Question> all = this.questionRepository.findAll();
		// assertEquals(2, all.size());

		// Question q = all.get(0);
		// assertEquals("sbb가 무엇인가요?", q.getSubject());

		// 3.
		// Optional<Question> oq = this.questionRepository.findById(1);
		// if(oq.isPresent()) {
		// 	Question q = oq.get();
		// 	assertEquals("sbb가 무엇인가요?", q.getSubject());
		// }

		// 4.
		// Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
		// assertEquals(1, q.getId());

		// 5.
		// Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb가 무엇인지에 대해서 알고 싶습니다.");
		// assertEquals(1, q.getId());
		
		// 6. sbb% sbb로 시작하는, %sbb sbb로 끝나는, %sbb% sbb를 포함하는
		// List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
		// Question q = qList.get(0);
		// assertEquals("sbb가 무엇인가요?", q.getSubject());

		// 7. 데이터 수정
		// Optional<Question> oq = this.questionRepository.findById(1);
		// assertTrue(oq.isPresent());
		// Question q = oq.get();
		// q.setSubject("수정된 제목");
		// this.questionRepository.save(q);

		// 8. 데이터 삭제
		// assertEquals(2, this.questionRepository.count());
		// Optional<Question> oq = this.questionRepository.findById(1);
		// assertTrue(oq.isPresent());
		// Question q = oq.get();
		// this.questionRepository.delete(q);
		// assertEquals(1, this.questionRepository.count());

		// 9. 질문 답변 생성
		// Optional<Question> oq = this.questionRepository.findById(2);
		// assertTrue(oq.isPresent());
		// Question q = oq.get();

		// Answer a = new Answer();
		// a.setContent("네 자동으로 생성됩니다.");
		// a.setQuestion(q);
		// a.setCreateDate(LocalDateTime.now());
		// this.answerRepository.save(a);

		// 10. 답변 조회
		// Optional<Answer> oa = this.answerRepository.findById(1);
		// assertTrue(oa.isPresent());
		// Answer a = oa.get();
		// assertEquals(2, a.getQuestion().getId());

		// 11. 질문에 달린 답변 조회
		// Question 리포지터리가 findById를 호출하여 Question 객체를 조회하고 나면 DB세션이 끊어지기 때문이다. 그 이후에 실행되는 q.getAnswerList() 메서드는 세션이 종료되어 오류가 발생한다. 답변 데이터 리스트는 q 객체를 조회할때 가져오지 않고 q.getAnswerList() 메서드를 호출하는 시점에 가져오기 때문에 오류 발생
		// 이렇게 필요한 시점에 데이터를 가져오는 방식을 Lazy 방식이라고 한다. 이와 반대로 q 객체를 조회할때 답변 리스트를 모두 가져오는 방식은 Eager 방식이라고 한다. @OneToMany, @ManyToOne 애너테이션의 옵션으로 fetch=FetchType.LAZY 또는 fetch=FetchType.EAGER 처럼 가져오는 방식을 설정할 수 있음.
		// 실제 서버에서 JPA 프로그램들을 실행할 때 DB 세션이 종료되지 않기 때문에 오류 발생하지 않음.
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> aList = q.getAnswerList();
		assertEquals(1, aList.size());
		assertEquals("네 자동으로 생성됩니다.", aList.get(0).getContent());
	}

}
