package com.mohaji._sb0401;

import com.mohaji._sb0401.entity.Memo;
import com.mohaji._sb0401.repository.MemoRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
class Sb0401ApplicationTests {

    @Autowired
    MemoRepository memoRepository;

    @PersistenceContext
    //entity
    private EntityManager em;

    @Test
    void emTest(){
        Memo memo =em.find(Memo.class, 2L);
        System.out.println(memo);
    }

    @Test
        //쿼리문을 jpa쪽에서 자동으로 만들어준다. Memo는 엔티티 이름/
        // mapper를 사용하지 않고 service 에 이 코드를바로 기록할 수 있다.
    void emTest2(){
        List<Memo> list= em.createQuery("select m from Memo m",Memo.class).getResultList();
        list.stream().forEach(e->{
            System.out.println(e);
        });
    }

    @Test
        //쿼리문을 jpa쪽에서 자동으로 만들어준다. Memo는 엔티티 이름/
        // mapper를 사용하지 않고 service 에 이 코드를바로 기록할 수 있다.
    void emTest3(){
        List<Memo> list= em.createQuery("from Memo m where m.mno>5",Memo.class).getResultList();
        list.stream().forEach(e->{
            System.out.println(e);
        });
    }
    @Test
    @Transactional
    void emInsert(){
        Memo memo= Memo.builder()
                .memoText("이것은 EM 테스트")
                .build();
        em.persist(memo);
    }


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
    @Test
    @Transactional
    @DisplayName("프로시저 테스트")
    void testProcedure() {
        for(Memo memo: memoRepository.getMemo()) {
            System.out.println(memo);
        }
    }
}
