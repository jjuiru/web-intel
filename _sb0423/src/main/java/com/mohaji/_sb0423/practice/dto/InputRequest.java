package com.mohaji._sb0423.practice.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class InputRequest {

  //  @NotEmpty // 빈 값을 에러로 넣어준다. 막지는 못함
    @NotBlank // null이 아니고 최소한 한개이상의 공백아닌 문자가 있는지 검사
    private String name;

    @NotNull //주로 인티저 타입에 사용한다.
    @Min(18) // 인티저 값의 범위를 설정한다. 최소 최대
    @Max(110)
    private Integer age;

    @Pattern(regexp = "^[0-9]{3}[-]+[0-9]{4}[-]+[0-9]{4}$", message = "'-'을 넣은 형식으로 작성해주세요.") //컨트롤러에서 validation을 따로 안만들어도된다.
    private String phone;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "'@'이메일 형식으로 작성해주세요.")
    private String email;

    private String addr;
}
