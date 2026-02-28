package com.capgemini.springbootbasic;

import java.util.List;

public class College {
	public String cname;
	public String location;
	
	List<Student> students;

	public College(String cname, String location, List<Student> students) {
		super();
		this.cname = cname;
		this.location = location;
		this.students = students;
	}

	@Override
	public String toString() {
		return "College [cname=" + cname + ", location=" + location + ", students=" + students + "]";
	}
}