package com.kt.bank.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kt.bank.dto.Account;
import com.kt.bank.dto.Member;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSession2;
	
	
	@Override
	public void insertMember(Member mem) throws Exception {
		sqlSession2.insert("mapper.member.insertMember", mem);
	}


	@Override
	public Member selectMember(String id) throws Exception {
		return sqlSession2.selectOne("mapper.member.selectMember", id);
	}

}
