package com.ll.sbbmission2;

import com.ll.sbbmission2.Entity.Question;
import com.ll.sbbmission2.Repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbMission2ApplicationTests {

    @Autowired //해당 클래스에서 db 를 사용하기위함
    QuestionRepository questionRepository;
    @Test
    void testJpa() {

        assertEquals(2,this.questionRepository.count()); //데이터가 2개인지 확인
        Optional<Question> oq = this.questionRepository.findById(1);// question 객체의 id값을 db 에서 찾는다
        assertTrue(oq.isPresent()); //1번 id 값이 존재 여부 확인
        Question q = oq.get();// 1번 값을 가져온다.
        this.questionRepository.delete(q); // 가져온 1번값을 삭제한다.
        assertEquals(1,this.questionRepository.count()); // 삭제 한 후 데이터가 1개 인지 확인
    }

}
