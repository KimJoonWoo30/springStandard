package com.spring.persistence;

import java.util.Date;

import com.spring.domain.UserVO;
import com.spring.dto.LoginDTO;

public interface UserDAO {

	public UserVO login(LoginDTO dto) throws Exception;

	public void keepLogin(String uid, String sessionId, Date next);

	public UserVO checkUserWithSessionKey(String value);
}
