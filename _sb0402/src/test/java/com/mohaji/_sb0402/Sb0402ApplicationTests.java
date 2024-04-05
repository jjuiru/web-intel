package com.mohaji._sb0402;

import com.mohaji._sb0402.entity.MyData;
import com.mohaji._sb0402.repository.MyDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class Sb0402ApplicationTests {

    @Autowired
    MyDataRepository myDataRepository;

//    @Test
    void contextLoads() {
        IntStream.rangeClosed(1,10).forEach(i->{
            MyData myData= MyData.builder()
                    .age(20+i)
                    .mail("kim"+i+"@korea.com")
                    .name("kim"+i)
                    .memo("이것은 메모"+i)
                    .build();
            myDataRepository.save(myData);
        });
    }

  //  @Test
    void contextUpdate() {
        MyData myData= MyData.builder()
                .id(1L) //프라이머리 키가 있으면 업데이트, 없으면 인서트
                .age(31)
                .mail("kim31@korea.com")
                .name("kim31")
                .memo("이것은 메모31")
                .build();
            myDataRepository.save(myData);
    }
   @Test
    void contextSelectAll() {
        List<MyData> list=myDataRepository.findAll();
        list.stream().forEach(m->{
            System.out.println(m);
        });
//        for(MyData myData:list){
//            System.out.println(myData);
//        }
    }

  //  @Test
    void contextSelectOne() {
     //   Mydata 1L의 값이 있는지 없는지 모르기때문에 오류가 날수 있다고 경고
        Optional<MyData> myData= myDataRepository.findById(1L);
        if(myData.isPresent()) {
            System.out.println(myData.get());
        }else {
            System.out.println("자료없음");
        }
    }
   // @Test
    void deleteOne() {
        myDataRepository.deleteById(10L);
        }


    @Test
    void contextFindId() {
        List<MyData> list=myDataRepository.findByIdBetween(3L,7L);
        list.stream().forEach(m->{
            System.out.println(m);
        });
    }

    @Test
    void contextFindId2() {
        List<MyData> list=myDataRepository.contextFindId3();
        list.stream().forEach(m->{
            System.out.println(m);
        });
    }
}


