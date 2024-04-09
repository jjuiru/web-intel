package com.mohaji._sb0408commandobject.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberListService {

    @Autowired
    private MemberDao memberDao;

    public List<Member> listService() {
        List<Member> member1 = memberDao.selectAll();
        return member1;
    }

}
