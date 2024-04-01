package com.mohaji._sb0401;

import com.mohaji._sb0401.entity.Memo;
import com.mohaji._sb0401.repository.MemoRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.stream.IntStream;

@SpringBootTest
class Sb0401ApplicationTests {

    @Autowired
    MemoRepository memoRepository;
    @Test
    void contextLoads() {
        System.out.println(memoRepository.getClass().getName());
    }

    @Test
    @DisplayName("메모 입력 테스트")
    void inertMemos(){
        IntStream.rangeClosed(1, 10).forEach(i-> {
            Memo memo= Memo.builder()
                    .memoText("이것은 테스트")
                    .build();
            memoRepository.save(memo);
        });
    }

    @Test
    @Transactional
    @DisplayName("메모 선택 테스트")
    void selectMemos() {
        Long mno = 9L;
       Memo memo = memoRepository.getOne(mno);
        System.out.println(memo);
    }
}
