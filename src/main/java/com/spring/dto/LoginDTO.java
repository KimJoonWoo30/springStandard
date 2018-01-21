package com.spring.dto;

//dto와 vo의 차이점은?
//dto는 화면에 가깝다.
//화면에 전달되는 데이터를 수집하는 용도로 사용하는 경우가 많다.
//vo는 데이터베이스와의 거리가 가깝다.
public class LoginDTO {
	private String uid;
	private String upw;
	private boolean useCookie;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public boolean isUseCookie() {
		return useCookie;
	}

	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}

	@Override
	public String toString() {
		return "LoginDTO [uid=" + uid + ", upw=" + upw + ", useCookie=" + useCookie + "]";
	}

}
