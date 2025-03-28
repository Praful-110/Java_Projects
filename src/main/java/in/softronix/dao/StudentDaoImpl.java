package in.softronix.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.softronix.entity.Student;
import in.softronix.factory.ConnectionFactory;


public class StudentDaoImpl implements StudentDao {

	String status ="";
	Connection con= ConnectionFactory.getConnection();
	String sql="";
	Student std = new Student();
	
	//-------------------------------Add Operations-----------------------------
	
	
	
	@Override
	public String add(Student std) {
		try {
			int sid = std.getSid();
			String sname =std.getSname();
			int smark = std.getSmark();
			String saddr = std.getSaddr();
			
			sql="insert into student values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, sid);
			ps.setString(2, sname);
			ps.setInt(3, smark);
			ps.setString(4, saddr);
			
			ps.execute();
			status ="success";
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	
	//-------------------------Search Operations-------------------------
	
	
	@Override
	public Student search(Integer sid) {
	    Student s = null; // Initialize properly
	    try {
	        sql = "SELECT * FROM student WHERE sid = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, sid);
	        ResultSet set = ps.executeQuery();
	        
	        if (set.next()) { // Move cursor to first row
	            s = new Student();
	            s.setSid(set.getInt("sid"));
	            s.setSname(set.getString("sname"));
	            s.setSmark(set.getInt("smarks"));
	            s.setSaddr(set.getString("saddr"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return s; // Return the student object
	}

	
	// -------------------------------Update Operation-----------------------------
	
	@Override
	public String update(Student std) {
	    String status="" ; // Initialize status

	    try {
	        String sql = "UPDATE student SET sname=?, smarks=?, saddr=? WHERE sid=?";
	        PreparedStatement ps = con.prepareStatement(sql);

	     
	        ps.setString(1, std.getSname());  
	        ps.setInt(2, std.getSmark());     
	        ps.setString(3, std.getSaddr());
	        ps.setInt(4, std.getSid()); 
	      
	        int rowsUpdated = ps.executeUpdate();
	        System.out.println("Rows updated: " + rowsUpdated);
	        
	        
	        if (rowsUpdated>0) {
	            System.out.println("Update successful! " + rowsUpdated + " row(s) updated.");
	        } else {
	            System.out.println("No record found with sid = " + std.getSid());
	        }

	       

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status; // Return status message
	}

	
	// -------------------------------Delete Operation-----------------------------

	@Override
	public String delete(Integer sid) {
		
		try {
			
			sql = "delete from student where sid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, sid);
			
			boolean b = ps.execute();
			
			status ="delete";
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	

	@Override
	public List<Student> getAllStudent() {
		List<Student> std = new ArrayList<Student>();
		
		
		try {
			
			sql = "select * from student";
			PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet set = ps.executeQuery();
			
			 while(set.next())
			 {
				 Student s = new Student();
				 
				 s.setSid(Integer.parseInt(set.getString("sid")));
				 s.setSname(set.getString("sname"));
				 s.setSmark(Integer.parseInt(set.getString("smarks")));
				 s.setSaddr(set	.getString("saddr"));
				 
				 std.add(s);
				 
			 }
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return std;
	
		
	}
		

}
