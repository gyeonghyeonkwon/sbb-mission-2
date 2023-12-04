package com.ll.sbbmission2.Controller;

import com.ll.sbbmission2.Entity.Question;
import com.ll.sbbmission2.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor// final 붙은 객체 생성자
@Controller
@RequestMapping("/question")
@Slf4j
public class QuestionController {

    private final QuestionService questionService;

  @GetMapping("/")
  public String showRedirect(){

      String s = "redirect:/question/list/";
      return s;
  }


   @GetMapping("/list")
   public String showList(Model model) {

       List<Question> questionList = this.questionService.getList();

       model.addAttribute("questionList", questionList);

       return "question_list";
   }

   @GetMapping("/detail/{id}")
   public String showDetail(Model model , @PathVariable("id")  Integer id) {

       Question question = this.questionService.getQuestion(id);

       model.addAttribute("question",question);

      log.info(question.getId().toString());

      return"/question_detail";
   }

}
