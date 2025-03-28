package in.softronix.service;

import java.util.List;


import in.softronix.entity.Student;

public interface StudentService 
{
	
	public String addStudent(Student std);
	
	public List<Student> getStudent();
		
	public Student searchStudent(Integer sid);
	
	public String updateStudent(Student std);
	
	public String deleteStudent(Integer sid);

}
