package com.ll.sbbmission2.Controller;

import com.ll.sbbmission2.Entity.Question;
import com.ll.sbbmission2.Service.AnswerService;
import com.ll.sbbmission2.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/answer")
@RequiredArgsConstructor
@Slf4j
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String showCreate(Model model , @PathVariable("id") Integer id, @RequestParam String content) {

        Question question = this.questionService.getQuestion(id);

        this.answerService.create(question , content);

        log.info(content);

        return "redirect:/question/detail/%s".formatted(id);
    }
}
