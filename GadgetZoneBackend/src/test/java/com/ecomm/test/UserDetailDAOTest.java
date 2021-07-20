package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.UserDetailDAO;
import com.ecomm.entity.UserDetail;

public class UserDetailDAOTest 
{
	static UserDetailDAO userDetailDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.ecomm");
		context.refresh();
		
		userDetailDAO=(UserDetailDAO)context.getBean("userDetailDAO");
	}
	
	@Test
	public void registerUserTest()
	{
		UserDetail user = new UserDetail();
		
		user.setUsername("praneeth");
		user.setCustomerName("chitta praneeth");
		user.setGender("Male");
		user.setContactNumber("9515062562");
		user.setEmailId("praneeth@gmail.com");
		user.setAddress("vijayawada");
		user.setEnabled(true);
		user.setPassword("12345");
		user.setrPassword("12345");
		user.setRole("ROLE_USER");
		
		assertTrue("Problem occured while Registering User:",userDetailDAO.registerUser(user));
		
	}

}
