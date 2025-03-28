package in.softronix.dao;

import java.util.List;


import in.softronix.entity.Student;

public interface StudentDao {
	
	public String add(Student std);

	public List<Student> getAllStudent();
	
	public Student search(Integer sid);
	
	public String update(Student std);
	
	public String delete(Integer sid);

}
