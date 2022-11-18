package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

// Entity 클래스는 컨트롤러에서 사용할수 없게끔 설계하는 것이 좋음.
// 그러기 위해선 DTO(data transfer object)가 필요
// 컨트롤러와 리포지터리 중간자적인 입장에서 Entity와 DTO의 객체를 서로 변환하여 양방향에 전달해주는 역할이 서비스
@RequiredArgsConstructor
@Service
public class QuestionService {
    
    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }
}
