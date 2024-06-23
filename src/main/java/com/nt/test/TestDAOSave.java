package com.nt.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dao.UserDAO;
import com.nt.model.User;

public class TestDAOSave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/config/spring-servlet.xml");
		
		UserDAO userDao = ctx.getBean(UserDAO.class);
		
		
		// for insert
//		User u = new User();
//		
//		u.setName("ranjeet");
//		u.setPhone("8010778734");
//		u.setEmail("ranjeet@gmail.com");
//		u.setAddress("Tikunia");
//		u.setLoginname("ranjeet8010");
//		u.setPassword("ranjeet@#123");
//		u.setRole(2); // Admin
//		u.setLooginStatus(1); // Active
//		
//		userDao.save(u);
//		System.out.println("------Data Saved ----------");
		
		
		// for deleting 
//		userDao.delete(1);
		
//		System.out.println("----- deleted ---------");
		
		
		// for update
		//User u = new User();
		
	//	u.setUserId(3);
//		u.setName("ranjeet.verma");
//		u.setPhone("8010778734");
//		u.setEmail("vermaranjeet@gmail.com");
//		u.setAddress("lakhimpur");
//		u.setRole(1); // Admin
//		u.setLooginStatus(2); // Active
		
//		userDao.update(u);
//		System.out.println("--Data Updated----");
		
		
		// for findbyid
		
//		User u = userDao.findById(4);
//		System.out.println("----User Details------------");
//		System.out.println(u.getUserId());
//		System.out.println(u.getName());
//		System.out.println(u.getPhone());
//		System.out.println(u.getEmail());
//		System.out.println(u.getAddress());
//		System.out.println(u.getLoginname());
//		System.out.println(u.getRole());
//		System.out.println(u.getLooginStatus());
		
		
		// For Findbyall
//		List<User> users = userDao.findAll();
//		int i = 1;
//		for(User u : users) {
//			System.out.println("----User Details " +i+" ------------");
//			i++;
//			System.out.println(u.getUserId());
//			System.out.println(u.getName());
//			System.out.println(u.getPhone());
//			System.out.println(u.getEmail());
//			System.out.println(u.getAddress());
//			System.out.println(u.getLoginname());
//			System.out.println(u.getRole());
//			System.out.println(u.getLooginStatus());
//		}
		
		
		// for findbyproperty
//		List<User> users = userDao.findByProperty("name","Vikram");
//		int i = 1;
//		for(User u : users) {
//			System.out.println("----User Details " +i+" ------------");
//			i++;
//			System.out.println(u);
//			System.out.println(u.getUserId());
//			System.out.println(u.getName());
//			System.out.println(u.getPhone());
//			System.out.println(u.getEmail());
//			System.out.println(u.getAddress());
//			System.out.println(u.getLoginname());
//			System.out.println(u.getRole());
//			System.out.println(u.getLooginStatus());
//		}
		
		ctx.close();

	}

}
