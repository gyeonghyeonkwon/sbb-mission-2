package com.ll.sbbmission2;

import com.ll.sbbmission2.Entity.Question;
import com.ll.sbbmission2.Repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbMission2ApplicationTests {

    @Autowired //해당 클래스에서 db 를 사용하기위함
    QuestionRepository questionRepository;
    @Test
    void testJpa() {

        Optional<Question> oq = this.questionRepository.findById(1);

        assertTrue(oq.isPresent());
        Question q= oq.get(); //값을 가져온다.
        q.setSubject("제목을수정한다.");
        this.questionRepository.save(q); // 수정한 값을 db 에저장 

    }

}
