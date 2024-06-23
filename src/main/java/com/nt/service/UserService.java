package com.nt.service;

import java.util.List;

import com.nt.exception.UserBlockedException;
import com.nt.model.User;

public interface UserService {
	
	    public static final Integer LOGIN_STATUS_ACTIVE=1;
	    public static final Integer LOGIN_STATUS_BLOCKED=2;
	    
	    public static final Integer ROLE_ADMIN=1;
	    public static final Integer ROLE_USER=2;

	    public void register(User u);
	    
	    public User login(String loginName, String password) throws UserBlockedException;
	    
	    /**
	    **
	     * Call this method to get list of registered users.
	     * @return 
	     */
	    public List getUserList();
	    
	    /**
	     * This method change the user login status for details passed as argument.
	     * @param userId
	     * @param loginStatus 
	     */
	    public void changeLoginStatus(Integer userId, Integer loginStatus);    
	    
	    
	    
	    
}
