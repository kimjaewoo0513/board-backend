package com.demo.member.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.demo.member.domain.Member;
import com.demo.member.dto.param.CreateMemberParam;

@Mapper
@Repository
public interface MemberDao {
	
	Integer isExistUserId(String id);
	
	Integer createMember(CreateMemberParam param);
	
	Member findById(String id);

}
