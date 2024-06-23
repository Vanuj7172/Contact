package com.nt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.nt.model.User;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO{

	@Override
	public void save(User u) {
		String sql = "INSERT INTO USER(name , phone , email , address , loginname , password , role , looginStatus ) VALUES (:name , :phone , :email , :address , :loginname , :password , :role , :looginStatus)";
		
		Map<String , Object> m = new HashMap<String , Object>();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("loginname", u.getLoginname());
		m.put("password", u.getPassword());
		m.put("role", u.getRole());
		m.put("looginStatus", u.getLooginStatus());
		
		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql,ps,kh);
		Integer userId = kh.getKey().intValue();
		u.setUserId(userId);
		
		
		
	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub
		
		String sql = "update user  set  name =:name, phone =:phone,email =:email , address =:address, role =:role, looginStatus =:looginStatus  WHERE userId =:userId";
		
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("role", u.getRole());
		m.put("looginStatus", u.getLooginStatus());
		m.put("userId", u.getUserId());
		
		SqlParameterSource ps = new MapSqlParameterSource(m);
		
		
		getNamedParameterJdbcTemplate().update(sql, ps);
		
		}

	@Override
	public void delete(User u) {
		this.delete(u.getUserId());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer userId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM USER WHERE userId = :userId";
		Map<String , Object> m = new HashMap<String , Object>();
		m.put("userId", userId);
		SqlParameterSource ps = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, ps);
		
	}

	@Override
	public User findById(Integer userId) {
		String sql = "SELECT userId ,name , phone ,email , address , loginname , role, looginStatus FROM user WHERE userId = ?";
		User u = getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<User>(User.class) , userId);
		return u;
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT userId ,name , phone ,email , address , loginname , role, looginStatus FROM user";
		
		List<User> users = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<User>(User.class));
		return users;
	}

	@Override
	public List<User> findByProperty(String propName, Object propValue) {
		// TODO Auto-generated method stub
		String sql = "SELECT userId ,name , phone ,email , address , loginname , role, looginStatus FROM user WHERE "+propName+ " = ?";
		List<User> users = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<User>(User.class),propValue);
		return users;
	}

}
