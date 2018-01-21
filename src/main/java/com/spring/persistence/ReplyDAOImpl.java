package com.spring.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.spring.mapper.ReplyMapper";

	@Override
	public List<ReplyVO> list(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".list", bno);
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", vo);
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int rno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete", rno);
	}

	@Override
	public List<ReplyVO> listPage(int bno, Criteria cri) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", bno);
		paramMap.put("cri", cri);

		return session.selectList(namespace + ".listPage", paramMap);
	}

	@Override
	public int count(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".count", bno);
	}

	@Override
	public int getBno(int rno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".getBno", rno);
	}

}
