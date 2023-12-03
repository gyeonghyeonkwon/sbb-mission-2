package com.ll.sbbmission2.Service;

import com.ll.sbbmission2.Entity.Question;
import com.ll.sbbmission2.Repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {

        return this.questionRepository.findAll();
    }

}
