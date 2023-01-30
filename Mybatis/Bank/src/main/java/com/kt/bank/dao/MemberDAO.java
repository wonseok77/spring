package com.kt.bank.dao;

import com.kt.bank.dto.Account;
import com.kt.bank.dto.Member;

public interface MemberDAO {

	void insertMember(Member mem) throws Exception;
	Member selectMember(String id) throws Exception;
}
