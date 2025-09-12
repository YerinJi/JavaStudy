package com.multi.springboot.DTO.Mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface MemberMapper {
    List<Member> findAll();
}