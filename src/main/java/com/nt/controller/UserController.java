package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.LoginCommand;
import com.nt.command.UserCommand;
import com.nt.exception.UserBlockedException;
import com.nt.model.User;
import com.nt.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/","/index"})
	public String index(Model m) {
		m.addAttribute("command", new LoginCommand());
		return "index";
	}
	
	
	
	@RequestMapping(value = {"/login"} , method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd , Model m , HttpSession session) {
		
		try {
		User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
		
			if(loggedInUser == null) {
				//FAILED
                //add error message and go back to login-form
                m.addAttribute("error", "Login Failed! Enter valid credentials.");
                return "index";//JSP - Login FORM
				
			}else //Success
			{
				if(loggedInUser.getRole().equals(userService.ROLE_ADMIN)) {
					addUserInsession(loggedInUser, session);
					return "redirect:admin/dashboard";
					
				}else if (loggedInUser.getRole().equals(userService.ROLE_USER)) 
				{addUserInsession(loggedInUser, session);
				return "redirect:user/dashboard";
				}
				
				else {
					m.addAttribute("error", "Invalid Role");
					return "index";
				}
			}
		
		
		}catch(UserBlockedException ex) {
			m.addAttribute("error", ex.getMessage());
			return "index";
			
		}
	}

	
	@RequestMapping(value= {"/reg_form"})
	public String registrationForm(Model m) {
		UserCommand cmd = new UserCommand();
		m.addAttribute("command",cmd );	
		return "reg_form"; //JSP Page
		
	} 
	
	
	@RequestMapping(value= {"/register"})
	public String registrationForm(@ModelAttribute("command") UserCommand cmd ,Model m) {
		
		try {
		User user = cmd.getUser();
		user.setRole(userService.ROLE_USER);
		user.setLooginStatus(userService.LOGIN_STATUS_ACTIVE);
		userService.register(user);
		
		return "redirect:index?act=reg"; //Login Page
		}
		
		catch(DuplicateKeyException e) {
			e.printStackTrace();
			m.addAttribute("error", "Username is already registered. Please select another username");
			
			return "reg_form";//
			
		}
		
	} 
	
	
	@RequestMapping(value= {"/logout"})
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index?act=lo";
	}
	
	
	
	@RequestMapping(value= {"/user/dashboard"})
	public String userDashboard() {
		return "dashboard_user";
	}
	
	@RequestMapping(value= {"/admin/dashboard"})
	public String adminDashboard() {
		return "dashboard_admin";
	}
	

	@RequestMapping(value= {"/admin/users"})
	public String getUsersList(Model m) {
		m.addAttribute("userList", userService.getUserList());
		return "users";
	}
	
	private void addUserInsession(User u , HttpSession session) {
		
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
		
	}
	
	
	

}
