package com.spring.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.domain.BoardVO;
import com.spring.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.spring.mapper.BoardMapper";

	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", vo);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete", bno);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	@Override
	public void updateReplyCnt(int bno, int amount) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bno", bno);
		paramMap.put("amount", amount);

		session.update(namespace + ".updateReplyCnt", paramMap);

	}

	@Override
	public void updateViewCnt(Integer bno) throws Exception {

		session.update(namespace + ".updateViewCnt", bno);

	}

	@Override
	public void addAttach(String fullName) throws Exception {

		session.insert(namespace + ".addAttach", fullName);
	}

	@Override
	public List<String> getAttach(int bno) throws Exception {
		return session.selectList(namespace + ".getAttach", bno);
	}

	@Override
	public void deleteAttach(int bno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".deleteAttach", bno);
	}

	@Override
	public void replaceAttach(String fullName, int bno) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("bno", bno);
		paramMap.put("fullName", fullName);

		session.insert(namespace + ".replaceAttach", paramMap);
	}
}
