package com.ll.sbbmission2.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키가 자동으로 증가한다 . 고유번호 id 값이 자동으로 증가하도록한다
    private Long id;

    @Column(length = 200)
    private String subject; //질문 제목

    @Column(columnDefinition = "TEXT")
    private String content; //질문 내용

    private LocalDateTime createDate; //날짜

    @OneToMany (mappedBy = "question" , cascade = CascadeType.REMOVE) //부모엔티티인 Question 객체가 삭제가되면 Answer 객체도 같이 삭제된다.
    private List<Answer> answerList;
}
