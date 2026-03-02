package com.capgemini.classtask;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Service
public class EmployeeService {
	EmployeeJpaRepository jpa;

	public EmployeeService(EmployeeJpaRepository jpa) {
		this.jpa = jpa;
	}
	
	public ModelAndView createEmployee(Employee e) {
		Optional<Employee> optional = jpa.findById(e.getEmail());
		ModelAndView mv = new ModelAndView();
		
		if(optional.isPresent()) {
			mv.addObject("msg", e.getName());
			mv.setViewName("exist");
			return mv;
		}
		else {
			Employee employee = jpa.save(e);
			mv.addObject("msg", e.getName());
			mv.setViewName("successfull");
			return mv;
		}
	}
	
    public ModelAndView login(@RequestParam String email,
                              @RequestParam String password) {

        ModelAndView mv = new ModelAndView();
        Employee e = jpa.findByEmailAndPassword(email, password);

        if (e.getRole().equalsIgnoreCase("admin")) {
            List<Employee> employees = jpa.findAll();
            mv.addObject("msg", employees);
            mv.setViewName("admin");
        } else {
            mv.addObject("msg", e);
            mv.setViewName("userdetails");
        }
        
        return mv;
    }

	public Employee findByEmailAndPassword(String email, String password) {
		return jpa.findByEmailAndPassword(email, password);
	}

	public ModelAndView getAdminPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/admin");
		return mv;
	}

	public void deleteEmployee(String email) {
		jpa.deleteById(email);
	}

	public List<Employee> getAllEmployees() {
		return jpa.findAll();
	}
}
