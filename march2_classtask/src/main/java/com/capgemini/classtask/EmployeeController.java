package com.capgemini.classtask;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
	private final EmployeeService service;
    private final EmployeeJpaRepository jpa;

    public EmployeeController(EmployeeService service, EmployeeJpaRepository jpa) {
        this.service = service;
        this.jpa = jpa;
    }
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/create")
	public ModelAndView create(@ModelAttribute Employee e) {
		return service.createEmployee(e);
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/loginCheck")
    public ModelAndView loginCheck(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role) {

        ModelAndView mv = new ModelAndView();

        Employee emp =
                service.findByEmailAndPassword(email, password);

        // LOGIN FAILED
        if (emp == null) {
            mv.setViewName("failure");
            return mv;
        }

        // ROLE NOT MATCH
        if (!emp.getRole().equalsIgnoreCase(role)) {
            mv.setViewName("role");
            return mv;
        }

        // ADMIN LOGIN
        if (role.equalsIgnoreCase("ADMIN")) {
            return service.getAdminPage();
        }

        // USER LOGIN
        mv.addObject("name", emp.getName());
        mv.setViewName("welcome");

        return mv;
    }
    
    

    @PostMapping("/deleteRecord")
    public String deleteRecord(@RequestParam String email) {

        service.deleteEmployee(email);

        return "redirect:/admin";
    }

    // ---------- ADMIN PAGE ----------
    @GetMapping("/admin")
    public ModelAndView adminPage() {

        ModelAndView mv = new ModelAndView();

        List<Employee> employees =
                service.getAllEmployees();

        mv.addObject("list_of_employees", employees);
        mv.setViewName("admin");

        return mv;
    }
}
