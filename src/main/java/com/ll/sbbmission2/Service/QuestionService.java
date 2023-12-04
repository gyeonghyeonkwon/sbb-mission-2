package com.ll.sbbmission2.Service;

import com.ll.sbbmission2.DataNotFoundException.DataNotFoundException;
import com.ll.sbbmission2.Entity.Question;
import com.ll.sbbmission2.Repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {

        return this.questionRepository.findAll();
    }

    // DB에 아이디 값이 존재 하면 반환 하고 아니면 예외를 발생시킨다.
    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()) {
            return question.get();
        }
        else{
            throw new DataNotFoundException("question not found");
        }
    }

}
