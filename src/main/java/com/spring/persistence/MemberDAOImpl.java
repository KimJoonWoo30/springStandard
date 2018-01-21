package com.spring.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.spring.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insertMember", vo);
	}

}
