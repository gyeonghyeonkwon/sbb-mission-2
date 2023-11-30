package com.ll.sbbmission2.Repository;

import com.ll.sbbmission2.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // 엔티티 Question  과 Interger는 해당 엔티티의 기본키 타입니다
public interface QuestionRepository extends JpaRepository<Question , Integer> {
        Question findBySubject(String subject); //findBysubject 를 기본으로 제공하지 않기때문에 해당코드를 작성해줘야한다
        Question findBySubjectAndContent(String subject , String content);

        List<Question> findBySubjectLike(String subject);
}

