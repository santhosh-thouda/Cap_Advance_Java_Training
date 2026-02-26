package com.springbasics;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("config.xml");
		
//		Person person = ioc.getBean("person", Person.class);
//		System.out.println(person);
//		person.message();
		
//		Employee employee = ioc.getBean("employee", Employee.class);
//		System.out.println(employee);
//		System.out.println(employee.getId());
//		System.out.println(employee.getName());
//		System.out.println(employee.getSalary());
		
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);
		Employee emp = ioc.getBean(Employee.class);
		System.out.println(emp);
	}
}