package com.ll.sbbmission2.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키가 자동으로 증가한다 . 고유번호 id 값이 자동으로 증가하도록한다
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content; //답변 내용

    private LocalDateTime createDate; //날짜

    @ManyToOne //N:1 관계이다. Answer 엔티티의  question 속성과 Question Entity가 서로 연결된다. , 부모엔티티는 Question 객체이다
    private Question question; //질문 엔티티
}
