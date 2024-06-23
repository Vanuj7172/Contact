package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.nt.dao.BaseDAO;
import com.nt.dao.ContactDAO;
import com.nt.model.Contact;
import com.nt.util.StringUtil;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService{
	
	@Autowired
	private ContactDAO contactDAO; 

	@Override
	public void save(Contact c) {
		// TODO Auto-generated method stub
		contactDAO.save(c);
		
	}

	@Override
	public void update(Contact c) {
		// TODO Auto-generated method stub
		contactDAO.update(c);
		
	}

	@Override
	public void delete(Integer contactId) {
		// TODO Auto-generated method stub
		contactDAO.delete(contactId);
		
	}

	@Override
	public void delete(Integer[] contactIds) {
		// TODO Auto-generated method stub
		String ids = StringUtil.toCommaSeparatedString(contactIds);
		String sql = "DELETE FROM CONTACT WHERE contactId IN ("+ids+")";
		getJdbcTemplate().update(sql);
		
	}

	@Override
	public List findUserContact(Integer userId) {
		// TODO Auto-generated method stub
		return contactDAO.findByProperty("userId", userId);
	}

	@Override
	public List findUserContact(Integer userId, String txt) {
		// TODO Auto-generated method stub
		   String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE userId=? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
	        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Contact.class),userId); 
	}

	@Override
	public Contact findbyId(Integer contactId) {
		// TODO Auto-generated method stub
		return contactDAO.findById(contactId);
		
	}

}
