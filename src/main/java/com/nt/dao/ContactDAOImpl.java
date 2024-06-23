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

import com.nt.model.Contact;


@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO {

	@Override
	public void save(Contact c) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO CONTACT(userId, name, phone, email, address, remark ) VALUES (:userId, :name, :phone, :email, :address, :remark)";
		Map<String , Object> m = new HashMap<String , Object>();
		m.put("userId", c.getUserId());
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());
		
		SqlParameterSource ps = new MapSqlParameterSource(m);
		KeyHolder kh = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql, ps, kh);
		c.setContactId(kh.getKey().intValue());
	
		
		
	}

	@Override
	public void update(Contact c) {
		// TODO Auto-generated method stub
		String sql = "UPDATE CONTACT SET name=:name, phone=:phone, email=:email, address=:address, remark=:remark WHERE contactId=:contactId";
		Map<String , Object> m = new HashMap<String , Object>();
		//m.put("userId", c.getUserId());
		m.put("contactId", c.getContactId());
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());
		getNamedParameterJdbcTemplate().update(sql, m);
		
		
	}

	@Override
	public void delete(Contact c) {
		// TODO Auto-generated method stub
		this.delete(c.getContactId());
		
	}

	@Override
	public void delete(Integer contactId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM CONTACT WHERE contactId = ?";
		getJdbcTemplate().update(sql , contactId);		
	}

	@Override
	public Contact findById(Integer contactId) {
		// TODO Auto-generated method stub
		String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM CONTACT WHERE contactId = ?";
		
		return getJdbcTemplate().queryForObject(sql , new BeanPropertyRowMapper<Contact>(Contact.class) , contactId);
		
	}

	@Override
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM CONTACT WHERE contactId = ?";
		return getJdbcTemplate().query(sql , new BeanPropertyRowMapper<Contact>(Contact.class) );
	}

	@Override
	public List<Contact> findByProperty(String propName, Object propValue) {
		// TODO Auto-generated method stub
		String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM CONTACT WHERE "+propName+ " = ?";
		return getJdbcTemplate().query(sql , new BeanPropertyRowMapper<Contact>(Contact.class) ,propValue);
	}

}
