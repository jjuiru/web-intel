package com.mohaji.dockertest2.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public int countMembers();
}
