package com.ll.sbbmission2;

import com.ll.sbbmission2.Entity.Answer;
import com.ll.sbbmission2.Entity.Question;
import com.ll.sbbmission2.Repository.AnswerRepository;
import com.ll.sbbmission2.Repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbMission2ApplicationTests {

    @Autowired //해당 클래스에서 db 를 사용하기위함
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;
    @Test
    void testJpa() {

        Optional<Question> oq = this.questionRepository.findById(2); // DB 에서 질문 아이디 에 대한 데이터를 찾아 oq 에 담는다
        assertTrue(oq.isPresent()); // 값이 존재한다면 true 반환 , 아니면 false
        Question q = oq.get(); // 값을 불러 온다

        Answer a = new Answer();

        a.setContent("네 자동으로 생성됩니다."); // 답변에 저장 할 내용
        a.setQuestion(q); //어떤 질문의 답변인기 알기위해서 Question 객체가 필요
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a); //답변저장
    }

}
