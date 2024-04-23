package com.sky.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
@Table(name="answer")
@Data
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @OrderColumn(name = "seq")
    @CollectionTable(name ="answer_data", joinColumns = @JoinColumn(name = "id"))
    private List<String> dataList;

    private int age;
    private String name;

    @Builder
    public AnswerEntity(List<String> dataList, int age, String name) {
        this.dataList = dataList;
        this.age = age;
        this.name = name;
    }

//    public static Answer toEntity(com.sky._sb0411.problem.Answer dto) {
//        return Answer.builder()
//                .dataList(dto.getDataList())
//                .age(dto.getAge())
//                .name(dto.getName())
//                .build();
//    }
}
