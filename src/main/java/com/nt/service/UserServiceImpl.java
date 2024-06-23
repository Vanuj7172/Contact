package com.nt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.nt.dao.BaseDAO;
import com.nt.dao.UserDAO;
import com.nt.exception.UserBlockedException;
import com.nt.model.User;

@Service
public class UserServiceImpl extends BaseDAO implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public void register(User u) {
		// TODO Auto-generated method stub
		userDAO.save(u);
		
	}

	@Override
	public User login(String loginName, String password) throws UserBlockedException {
		String sql = "SELECT userId ,name , phone ,email , address , loginname , role, looginStatus FROM user WHERE loginname =:ln AND password =:pw";
		
		Map<String,Object> map = new HashMap<>();
		map.put("ln",loginName);
		map.put("pw",password);
		
		try {
		User u= getNamedParameterJdbcTemplate().queryForObject(sql, map, new BeanPropertyRowMapper<User>(User.class));
		if(u.getLooginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
			 throw new UserBlockedException("Your account has been blocked. Contact to admin");
		}
		else {
			return u;
		}
		
		}catch(EmptyResultDataAccessException ex) {
			return null;
			
		}
		
		
	}

	@Override
	public List getUserList() {
		// TODO Auto-generated method stub
		
		return userDAO.findByProperty("role", UserService.ROLE_USER);
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		// TODO Auto-generated method stub
		
	}

}
