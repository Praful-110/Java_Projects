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



@WebServlet("/delete/*")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher rd =null;

	StudentService service = ServiceFactory.getService();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("Please Check Servelet.................");
		
		String param =request.getPathInfo();
		System.out.println(param);
		
		int sid=Integer.parseInt(param.substring(1));
		String status = service.deleteStudent(sid);
		
		while(true)
		{
			if(status.equals("delete"))
			{
				List<Student> student =service.getStudent();
				
				while(student !=null)
				{
					request.setAttribute("student", student);
					rd = request.getRequestDispatcher("/display.jsp");
					rd.forward(request, response);	
				}
				
			}
		}
		
	}

}
