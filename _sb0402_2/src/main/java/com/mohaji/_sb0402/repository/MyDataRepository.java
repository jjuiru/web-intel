package com.mohaji._sb0402.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mohaji._sb0402.entity.MyData;
public interface MyDataRepository extends JpaRepository<MyData, Long> {

}
