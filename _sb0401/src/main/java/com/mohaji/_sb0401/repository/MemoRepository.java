package com.mohaji._sb0401.repository;

import com.mohaji._sb0401.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    // entity이름 타입
}
