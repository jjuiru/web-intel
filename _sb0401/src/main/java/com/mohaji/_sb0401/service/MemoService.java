package com.mohaji._sb0401.service;

import com.mohaji._sb0401.entity.Memo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class MemoService {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void emInsert(){
        Memo memo= Memo.builder()
                .memoText("이것은 EM 테스트")
                .build();
        em.persist(memo); // insert
    }

    void emTest(){
        Memo memo =em.find(Memo.class, 2L);
    }
}
