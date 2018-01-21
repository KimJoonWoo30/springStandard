package com.spring.domain;

// page번호와 각 페이지당 게시글 수 조정을 위한 클래스 
// 사실상 변수로 두었어도 됬으나, 관리와 관상을 위해 클래스로 제작
public class Criteria {

	private int page;
	private int perPageNum;

	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public void setPage(int page) {

		if (page <= 0) {
			this.page = 1;
			return;
		}

		this.page = page;
	}

	public void setPerPageNum(int perPageNum) {

		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}

		this.perPageNum = perPageNum;
	}

	public int getPage() {
		return page;
	}

	// method for MyBatis SQL Mapper
	public int getPageStart() {

		return (this.page - 1) * perPageNum;
	}

	// method for MyBatis SQL Mapper
	public int getPerPageNum() {

		return this.perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", " + "perPageNum=" + perPageNum + "]";
	}
}
