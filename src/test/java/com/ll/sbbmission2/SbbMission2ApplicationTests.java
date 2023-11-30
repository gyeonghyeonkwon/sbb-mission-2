package com.ll.sbbmission2;

import com.ll.sbbmission2.Entity.Answer;
import com.ll.sbbmission2.Repository.AnswerRepository;
import com.ll.sbbmission2.Repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SbbMission2ApplicationTests {

    @Autowired //해당 클래스에서 db 를 사용하기위함
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;
    @Test
    void testJpa() {

        Optional<Answer> oa = this.answerRepository.findById(1); //답변 id 가 1 인데이터를 찾아 oa 담는다
        assertTrue(oa.isPresent()); //값을 존재하는지 확인한다.
        Answer a= oa.get();
        assertEquals(2, a.getQuestion().getId()); //질문 아이디 값이 2인지 확인한다
    }

}
