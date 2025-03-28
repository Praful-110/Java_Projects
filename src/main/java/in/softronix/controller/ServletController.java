package in.softronix.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.softronix.entity.Student;
import in.softronix.factory.ServiceFactory;
import in.softronix.service.StudentService;



@WebServlet("/add")
public class ServletController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
      
	
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String button_label= request.getParameter("button");//add
		StudentService service = ServiceFactory.getService();
		RequestDispatcher rd;
		String status="";
		Student std = new Student();
		
		
		//-----------------------add-------------------------
		
		if(button_label.equals("add")) 
		{
			
			std.setSid(Integer.parseInt(request.getParameter("sid")));
			std.setSname(request.getParameter("sname"));
			std.setSmark(Integer.parseInt(request.getParameter("smarks")));
			std.setSaddr(request.getParameter("saddr"));
			
			System.out.println(std.getSid());
			System.out.println(std.getSname());
			System.out.println(std.getSmark());
			System.out.println(std.getSaddr());
			
			status = service.addStudent(std);
			
			if(status.equals("success"))
			{
				rd= request.getRequestDispatcher("./success.html");
				rd.forward(request, response);
			}
			if(status.equals("failed"))
			{
				rd= request.getRequestDispatcher("./failed.html");
				rd.forward(request, response);
			}
			
			
		}
		
		
		//-------------------------display------------------------------------------
		
		if(button_label.equals("display"))
		{
			
			List<Student >student = service.getStudent();
			
			if(student!=null)
			{
				
				
				request.setAttribute("student", student);
				rd=request.getRequestDispatcher("/display.jsp");
				rd.forward(request, response);
				
			}
			else 
			{
				rd=request.getRequestDispatcher("/empty.html");
				rd.forward(request, response);
			}
			
		}
		
	}


	private boolean button_label(String string) {
		// TODO Auto-generated method stub
		return false;
	}


	

}
