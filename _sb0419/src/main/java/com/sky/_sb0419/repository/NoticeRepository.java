package com.sky._sb0419.repository;

import com.sky._sb0419.Entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice,Long> {

    //네이티브쿼리
    @Modifying
    @Transactional
    @Query(value = "insert into notice(title, content, regdate) values" +
    "(:#{#notice.title},:#{#notice.content},CURRENT_TIMESTAMP )"
    , nativeQuery = true)
    public void insertNotice(@Param("notice") Notice notice);

    @Query(value = "select count (*) from notice", nativeQuery = true)
    public Long selectCount();

    @Query(value = "select * from notice order by seq desc", nativeQuery = true)
    public List<Notice> selectOrderSeq();

    public List<Notice> findAllByOrderBySeqDesc(); //쿼리메소드라고 부른다.
}
