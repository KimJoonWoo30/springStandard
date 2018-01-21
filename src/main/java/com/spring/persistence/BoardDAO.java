package com.spring.persistence;

import java.util.List;

import com.spring.domain.BoardVO;
import com.spring.domain.SearchCriteria;

public interface BoardDAO {

	public void create(BoardVO vo) throws Exception;

	public BoardVO read(int bno) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(int bno) throws Exception;

	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public void updateReplyCnt(int bno, int amount) throws Exception;

	public void updateViewCnt(Integer bno) throws Exception;

	public void addAttach(String fullName) throws Exception;

	public List<String> getAttach(int bno) throws Exception;

	public void deleteAttach(int bno) throws Exception;

	public void replaceAttach(String fullName, int bno) throws Exception;
}
