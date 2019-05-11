package edu.mum.main;


import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

public class Main {
  public static void main(String[] args) {

	  ApplicationContext context = new ClassPathXmlApplicationContext("context/applicationContext.xml");

		    UserService userService = (UserService) context.getBean("userServiceImpl");


		    User user = new User();
		    user.setFirstName("John");
		    user.setLastName("Doe");
		    user.setEmail("jdoe@mum.edu");
		   // user.setRating(0);
		   // user.setAdmin(false);
		   // user.setVersion(0);
		    user.setLastLogin(new Date());
		    userService.save(user);
		    System.out.println("User inserted!");

		    List<User> list = userService.findAll();
		    System.out.println("User count: " + list.size());
		    
		    User currentUser = userService.findByEmail("jdoe@mum.edu");
		    
		    System.out.println();
		    System.out.println("        *********  USER **********");

		    System.out.println("User Name: " + currentUser.getFirstName() + " " + currentUser.getLastName());


     
  }  
  
 }