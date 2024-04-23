package com.sky._sb0411.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection // 테이블이 하나 생성된다. h2 db
    private List<String> dataList;
    private int age;
    private String name;

    @Builder
    public Answer(List<String> dataList, int age, String name) {
        this.dataList = dataList;
        this.age = age;
        this.name = name;
    }

    // dto를 받아서 엔티티로 바꿔준다.
    public static Answer toEntity(com.sky._sb0411.problem.Answer dto) {
        return Answer.builder()
                .dataList(dto.getDataList())
                .age(dto.getAge())
                .name(dto.getName())
                .build();
    }
}
