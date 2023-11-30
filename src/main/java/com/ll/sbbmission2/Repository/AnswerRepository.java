package com.ll.sbbmission2.Repository;

import com.ll.sbbmission2.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //엔티티 Answer  과 Interger는 해당 엔티티의 기본키 타입니다
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
