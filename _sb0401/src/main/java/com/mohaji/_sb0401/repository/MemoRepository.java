package com.mohaji._sb0401.repository;

import com.mohaji._sb0401.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    @Procedure("pro_2")
    List<Memo> getMemo();
}
