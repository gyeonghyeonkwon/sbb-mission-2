package com.ll.sbbmission2;

import com.ll.sbbmission2.Entity.Answer;
import com.ll.sbbmission2.Entity.Question;
import com.ll.sbbmission2.Repository.AnswerRepository;
import com.ll.sbbmission2.Repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbMission2ApplicationTests {

    @Autowired //해당 클래스에서 db 를 사용하기위함
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;
    @Transactional
    @Test
    void testJpa() {

        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
    }

}
