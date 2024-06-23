package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.model.User;
import com.nt.service.UserService;

public class TestService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/config/spring-servlet.xml");
		
		UserService userService = ctx.getBean(UserService.class);
		
		// for Register
		User u = new User();
		
		u.setName("Abhi");
		u.setPhone("72600067");
		u.setEmail("abhi@gmail.com");
		u.setAddress("motipur");
		u.setLoginname("abhi67");
		u.setPassword("abhi@#123");
		u.setRole(UserService.ROLE_ADMIN); // Admin
		u.setLooginStatus(userService.LOGIN_STATUS_ACTIVE); // Active
		
		userService.register(u);
		System.out.println("----User register sucessfully---");
				

	}

}
