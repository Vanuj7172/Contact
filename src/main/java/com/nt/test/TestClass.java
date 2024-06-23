package com.nt.test;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestClass {

	public static void main(String[] args) {
		// create IOC container
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/config/spring-servlet.xml");
				
				DataSource ds = ctx.getBean(DataSource.class);
				
				JdbcTemplate jt = new JdbcTemplate(ds);
				
				String sql = "INSERT INTO user (name,phone,email,address,loginname,password) VALUES(?,?,?,?,?,?)";
				Object[] paaram = new Object[] {"Anuj","6307467172","vanuj7172@gmail.com","lakhimpur","anuj7172","Anuj@#123"};
				jt.update(sql,paaram);
				
				System.out.println("----SQL Excuted -----------");
				
				ctx.close();
				
	}

}
