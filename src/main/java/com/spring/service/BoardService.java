package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;
import com.spring.domain.SearchCriteria;

public interface BoardService {

	public void regist(BoardVO board) throws Exception;

	public BoardVO read(Integer bno) throws Exception;

	public void modify(BoardVO board) throws Exception;

	public void remove(Integer bno) throws Exception;

	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public List<String> getAttach(int bno) throws Exception;
}
