package com.ll.sbbmission2.Controller;

import com.ll.sbbmission2.Entity.Question;
import com.ll.sbbmission2.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor// final 붙은 객체 생성자
@Controller
public class QuestionController {

    private final QuestionService questionService;

  @GetMapping("/")
  public String showRedirect(){

      return "redirect:question/list";
  }


   @GetMapping("/question/list")
   public String showList(Model model) {

       List<Question> questionList = this.questionService.getList();

       model.addAttribute("questionList", questionList);

       return "question_list";
   }
}
