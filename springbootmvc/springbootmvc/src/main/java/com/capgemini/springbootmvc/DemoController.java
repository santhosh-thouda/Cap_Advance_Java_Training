package com.capgemini.springbootmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DemoController {
	
	@Autowired
	UsersJpaRepository jpa;
	
	@GetMapping("/hello")
	public String getHi() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String createAccount() {
		return "register";
	}
	
//	@PostMapping("/create-account")
//	public String register(HttpServletRequest request) {
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String number = request.getParameter("number");
//		
//		System.out.println(name);
//		System.out.println(email);
//		System.out.println(number);
//		
//		return "success";		
//	}
	
	
//	@PostMapping("create-account")
//	public String register(@ModelAttribute Users users) {
//		System.out.println(users.getName());
//		System.out.println(users.getEmail());
//		System.out.println(users.getNumber());
//		
//		return "success";
//	}
	
	
	@PostMapping("create-account")
	public String register(@ModelAttribute Users users) {
		jpa.save(users);
		
		return "success";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logincheck")
	public String loginCheck(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Users user = jpa.findByEmailAndPassword(email, password);
		if(user != null) {
			return "loginsuccess";
		}
		else {
			return "redirect:login";
		}
	}
	
	@GetMapping("/hii")
	public ModelAndView sendData() {
		ModelAndView mv = new ModelAndView();
		List<String> list = List.of("Santhu", "Dheeraj", "Uthkarsh", "Shashwat");
		mv.addObject("msg", list);
		mv.setViewName("abc");
		return mv;
	}
}