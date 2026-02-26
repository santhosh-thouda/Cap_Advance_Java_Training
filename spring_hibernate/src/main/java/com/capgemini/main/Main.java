package com.capgemini.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.ProjectConfiguration;

public class Main {

	// single ton -> one object
	// to avoid single ton we use @Scope("prototype") on class here on employee class
	public static void main(String[] args) {
		ApplicationContext ioc = new AnnotationConfigApplicationContext(ProjectConfiguration.class); // when ioc is created all the beans are created
		
		AnnotationConfigApplicationContext ac = (AnnotationConfigApplicationContext)ioc; 
		ac.close();
//		Employee e1 = ioc.getBean(Employee.class);
//		
//		Employee e2 = ioc.getBean(Employee.class);
//		e2.setName("Miller");
//		
//		System.out.println(e1);
//		System.out.println(e2);
//		System.out.println(e1==e2);
//		
//		EmployeeDao ed = ioc.getBean(EmployeeDao.class);
////		ed.insert(e2);
////		ed.updateById(0);
//		ed.deleteById(0);
		
	}
}